package com.acvrock.web;

import com.acvrock.domain.Member;
import com.acvrock.domain.Msg;
import com.acvrock.domain.ScoreRecord;
import com.acvrock.service.MemberService;
import com.acvrock.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @Autowired
    ScoreRecordService scoreRecordService;

    @Autowired
    MemberService memberService;

    @RequestMapping("/")
    public String index(Model model) {
        Member member = (Member) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        member = memberService.findByMemberName(member.getMemberName());
        Msg msg = new Msg("会员信息", "展示会员信息", member);
        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping("/editPassword")
    public String editPassword(Model model, HttpServletRequest request,
                               @RequestParam(value = "oldpassword", defaultValue = "") String oldpassword,
                               @RequestParam(value = "password", defaultValue = "") String password) {
        Member member = (Member) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Msg msg;
        if ("POST".equals(request.getMethod())) {
            msg = memberService.editPassword(oldpassword, password, member);
        } else {
            msg = new Msg("修改密码", "0", null);
        }
        model.addAttribute("msg", msg);
        return "editPassword";
    }

    @RequestMapping("/transferScore")
    public String transferScore(Model model, HttpServletRequest request,
                                @RequestParam(value = "memberPhone", defaultValue = "") String memberPhone,
                                @RequestParam(value = "memberName", defaultValue = "") String memberName,
                                @RequestParam(value = "score", defaultValue = "") Long score,
                                @RequestParam(value = "remark", defaultValue = "") String remark
    ) {
        Member member = (Member) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Msg msg;
        if ("POST".equals(request.getMethod())) {
            msg = scoreRecordService.transferScore(memberPhone, memberName, score, remark, member);
        } else {
            member = memberService.findByMemberName(member.getMemberName());
            msg = new Msg("积分转赠", "0", null);
        }
        model.addAttribute("msg", msg);
        model.addAttribute("member", member);
        return "transferScore";
    }


    @RequestMapping("/scoreRecord")
    public String scoreRecord(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "15") Integer size, Model model) {
        Member member = (Member) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Page<ScoreRecord> all = scoreRecordService.findByMember(page, size,member);
        Msg msg = new Msg("积分记录", "展示会员积分信息", all);
        model.addAttribute("msg", msg);
        return "scoreRecord";
    }

}

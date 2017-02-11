package com.acvrock.web;

import com.acvrock.dao.ScoreRecordRepository;
import com.acvrock.domain.Member;
import com.acvrock.domain.Msg;
import com.acvrock.domain.ScoreRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @Autowired
    ScoreRecordRepository scoreRecordRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Member member = (Member) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Msg msg = new Msg("会员信息", "展示会员信息", member);
        model.addAttribute("msg", msg);
        return "home";
    }

    @RequestMapping("/scoreRecord")
    public String scoreRecord(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "15") Integer size
            , Model model) {
        Member member = (Member) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Sort sort = new Sort(Sort.Direction.DESC, "scoreRecordID");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<ScoreRecord> all = scoreRecordRepository.findAll(pageable);
        System.out.println(all.isFirst());

        Msg msg = new Msg("积分记录", "展示会员积分信息", all);
        model.addAttribute("msg", msg);
        return "scoreRecord";
    }

}

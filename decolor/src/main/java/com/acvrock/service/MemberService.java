package com.acvrock.service;

import com.acvrock.dao.MemberRepository;
import com.acvrock.domain.Member;
import com.acvrock.domain.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberName) {
        Member member = memberRepository.findByMemberName(memberName);
        if (member == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return member;
    }

    public Member findByMemberName(String memberName) {
        return memberRepository.findByMemberName(memberName);
    }


    public Msg editPassword(String oldpassword, String password, Member member) {
        Msg msg = new Msg("修改密码", "0", null);
        if (StringUtils.isEmpty(oldpassword) || StringUtils.isEmpty(password)) {
            msg.setContent("1");
            msg.setEtraInfo("输入密码不能为空");
            return msg;
        }
        if (!member.getMemberPwd().equals(oldpassword)) {
            msg.setContent("1");
            msg.setEtraInfo("旧密码错误");
            return msg;
        }
        member.setMemberPwd(password);
        memberRepository.save(member);
        msg.setContent("2");
        return msg;
    }

}

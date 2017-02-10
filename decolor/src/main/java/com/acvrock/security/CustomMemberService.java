package com.acvrock.security;

import com.acvrock.dao.MemberRepository;
import com.acvrock.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomMemberService implements UserDetailsService {
	@Autowired
	MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String memberName) {
		
		Member member = memberRepository.findByMemberName(memberName);
		if(member == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return member;
	}

}

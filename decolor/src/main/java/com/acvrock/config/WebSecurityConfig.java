package com.acvrock.config;

import com.acvrock.service.MemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//1
	
	@Resource
	MemberService memberService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService); //3
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.anyRequest().authenticated() //4
						.and()
						.formLogin()
							.loginPage("/login")
							.failureUrl("/login?error")
							.permitAll() //5
						.and()
						.logout().permitAll(); //6
		

	}


}

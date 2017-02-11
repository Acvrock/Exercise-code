package com.acvrock.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name = "member")
public class Member implements UserDetails{ //1
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long memberID;
	private String memberPhone;
	private String memberName;
	private String memberPwd;
	private Long memberScore;

	
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	private List<MemberRole> roles;
//
//	@OneToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
//	private List<ScoreRecord> scoreRecords;
//
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //2
		List<GrantedAuthority> auths = new ArrayList<>();
		List<MemberRole> roles=this.getRoles();
		for(MemberRole role:roles){
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auths;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getUsername() {
		return memberName;
	}
	public void setUsername(String username) {
		this.memberName = username;
	}
	public String getPassword() {
		return memberPwd;
	}
	public void setPassword(String password) {
		this.memberPwd = password;
	}

	public Long getMemberID() {
		return memberID;
	}

	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public Long getMemberScore() {
		return memberScore;
	}

	public void setMemberScore(Long memberScore) {
		this.memberScore = memberScore;
	}

	public List<MemberRole> getRoles() {
		return roles;
	}
	public void setRoles(List<MemberRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Member{" +
				"memberID=" + memberID +
				", memberPhone='" + memberPhone + '\'' +
				", memberName='" + memberName + '\'' +
				", memberPwd='" + memberPwd + '\'' +
				", memberScore='" + memberScore + '\'' +
				", roles=" + roles +
				'}';
	}
}

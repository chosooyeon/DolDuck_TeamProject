package com.my.dolduck.model.dto;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MemberDto extends User{
	private int member_seq;
	private String member_id;
//	private String member_pw;
//	private String member_name;
	private String member_phone;
	private String member_addr;
	private String member_email;
	private Date member_regdate;
//	private boolean member_enabled;
	private String member_role;
	private int member_heart;
	private int member_vote;
	private String member_img;

	
	public MemberDto(String username, String password, boolean enabled, 
			boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, int member_seq, String member_id, String member_phone, String member_addr,
			String member_email, String member_role, int member_heart, int member_vote, String member_img ){
		//userClass에 보내는 코드
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.member_seq = member_seq;
		this.member_id = member_id;
		this.member_phone = member_phone;
		this.member_addr = member_addr;
		this.member_email = member_email;
		this.member_role = member_role;
		this.member_heart = member_heart;
		this.member_vote = member_vote;
		this.member_img = member_img;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public Date getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}

	public String getMember_role() {
		return member_role;
	}

	public void setMember_role(String member_role) {
		this.member_role = member_role;
	}
	
	public int getMember_heart() {
		return member_heart;
	}

	public void setMember_heart(int member_heart) {
		this.member_heart = member_heart;
	}

	public int getMember_vote() {
		return member_vote;
	}

	public void setMember_vote(int member_vote) {
		this.member_vote = member_vote;
	}

	public String getMember_img() {
		return member_img;
	}

	public void setMember_img(String member_img) {
		this.member_img = member_img;
	}

	@Override
	public String toString() {
		return "MemberDto [member_seq=" + member_seq + ", member_id=" + member_id + ", member_phone=" + member_phone
				+ ", member_addr=" + member_addr + ", member_email=" + member_email + ", member_regdate="
				+ member_regdate + ", member_role=" + member_role + ", member_heart=" + member_heart + ", member_vote="
				+ member_vote + "]";
	}

	
	
	
}

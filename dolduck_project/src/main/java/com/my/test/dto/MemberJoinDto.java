package com.my.test.dto;

public class MemberJoinDto {
	private String member_id;
	private String member_phone;
	private String member_addr;
	private String member_email;
	
	public MemberJoinDto() {
		super();
	}
	public MemberJoinDto(String member_id, String member_phone, String member_addr, String member_email) {
		super();
		this.member_id = member_id;
		this.member_phone = member_phone;
		this.member_addr = member_addr;
		this.member_email = member_email;
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
	
	
}

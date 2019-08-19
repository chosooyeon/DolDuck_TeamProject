package com.my.dolduck.model.dto;

import java.io.Serializable;
import java.util.Date;

public class SelectDto implements Serializable{
	
	private int member_seq;
	private String member_id;
	private String member_name;
	private String member_phone;
	private String member_addr;
	private String member_email;
	private Date member_regdate;
	private boolean member_enabled;
	private String member_role;
	private int member_heart;
	private int member_vote;
	
	public SelectDto() {
		super();
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

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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

	public boolean isMember_enabled() {
		return member_enabled;
	}

	public void setMember_enabled(boolean member_enabled) {
		this.member_enabled = member_enabled;
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

}

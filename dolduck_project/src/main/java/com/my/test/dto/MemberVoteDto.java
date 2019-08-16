package com.my.test.dto;

public class MemberVoteDto {
	private String member_id;
	private int voteNumber;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getVoteNumber() {
		return voteNumber;
	}
	public void setVoteNumber(int voteNumber) {
		this.voteNumber = voteNumber;
	}
	public MemberVoteDto() {
	}
	public MemberVoteDto(String member_id, int voteNumber) {
		super();
		this.member_id = member_id;
		this.voteNumber = voteNumber;
	}
}

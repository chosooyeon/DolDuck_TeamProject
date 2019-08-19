package com.my.dolduck.model.dto;

public class VoteDto {
	
	private int page;
	private String starName;
	private int voteNumber;
	
	public VoteDto() {
	}
	
	public VoteDto(int page, String starName) {
		super();
		this.page = page;
		this.starName = starName;
	}
	public VoteDto(int page, String starName, int voteNumber) {
		super();
		this.page = page;
		this.starName = starName;
		this.voteNumber = voteNumber;
	}
	
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public String getStarName() {
		return starName;
	}
	
	public void setStarName(String starName) {
		this.starName = starName;
	}
	
	public int getVoteNumber() {
		return voteNumber;
	}
	
	public void setVoteNumber(int voteNumber) {
		this.voteNumber = voteNumber;
	}
	
	@Override
	public String toString() {
		return "VoteDto [page=" + page + ", starName=" + starName + ", voteNumber=" + voteNumber + "]";
	}
}

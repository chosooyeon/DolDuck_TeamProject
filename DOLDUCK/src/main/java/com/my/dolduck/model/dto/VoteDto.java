package com.my.dolduck.model.dto;

public class VoteDto {
	
	private String item;
	private String starName;
	private int voteNumber;
	
	public VoteDto() {
	}
	public VoteDto(String item, String starName) {
		super();
		this.item = item;
		this.starName = starName;
	}
	public VoteDto(String item, String starName, int voteNumber) {
		super();
		this.item = item;
		this.starName = starName;
		this.voteNumber = voteNumber;
	}
	
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
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
		return "VoteDto [item=" + item + ", starName=" + starName + ", voteNumber=" + voteNumber + "]";
	}
}

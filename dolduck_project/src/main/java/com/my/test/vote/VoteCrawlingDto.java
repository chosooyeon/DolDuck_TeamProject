package com.my.test.vote;

public class VoteCrawlingDto {
	private String name;
	private String img;

	public VoteCrawlingDto() {
		super();
	}
	public VoteCrawlingDto(String name, String img) {
		super();
		this.name = name;
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}

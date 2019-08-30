package com.my.dolduck.model.dto;

public class BroadcastDto {

	private int broadcast_seq;
	private String broadcast_date;
	private String broadcast_caster;
	private String broadcast_title;
	private String broadcast_content;
	private String broadcast_room;
	
	public BroadcastDto() {}

	public BroadcastDto(int broadcast_seq, String broadcast_date, String broadcast_time, String broadcast_caster, String broadcast_title,
			String broadcast_content, String broadcast_room) {
		super();
		this.broadcast_seq = broadcast_seq;
		this.broadcast_date = broadcast_date;
		this.broadcast_caster = broadcast_caster;
		this.broadcast_title = broadcast_title;
		this.broadcast_content = broadcast_content;
		this.broadcast_room = broadcast_room;
	}

	//Constructor for INSERT
	public BroadcastDto(String broadcast_date, String broadcast_caster, String broadcast_title) {
		super();
		this.broadcast_date = broadcast_date;
		this.broadcast_caster = broadcast_caster;
		this.broadcast_title = broadcast_title;
	}

	//Constructor for UPDATE
	public BroadcastDto(int broadcast_seq, String broadcast_date, String broadcast_title, String broadcast_content) {
		super();
		this.broadcast_seq = broadcast_seq;
		this.broadcast_date = broadcast_date;
		this.broadcast_title = broadcast_title;
		this.broadcast_content = broadcast_content;
	}

	//Constructor for DELETE
	public BroadcastDto(int broadcast_seq) {
		super();
		this.broadcast_seq = broadcast_seq;
	}


	//Getter & Setter
	
	public int getBroadcast_seq() {
		return broadcast_seq;
	}

	public void setBroadcast_seq(int broadcast_seq) {
		this.broadcast_seq = broadcast_seq;
	}

	public String getBroadcast_date() {
		return broadcast_date;
	}

	public void setBroadcast_date(String broadcast_date) {
		this.broadcast_date = broadcast_date;
	}
	

	public String getBroadcast_caster() {
		return broadcast_caster;
	}

	public void setBroadcast_caster(String broadcast_caster) {
		this.broadcast_caster = broadcast_caster;
	}

	public String getBroadcast_title() {
		return broadcast_title;
	}

	public void setBroadcast_title(String broadcast_title) {
		this.broadcast_title = broadcast_title;
	}

	public String getBroadcast_content() {
		return broadcast_content;
	}

	public void setBroadcast_content(String broadcast_content) {
		this.broadcast_content = broadcast_content;
	}

	public String getBroadcast_room() {
		return broadcast_room;
	}

	public void setBroadcast_room(String broadcast_room) {
		this.broadcast_room = broadcast_room;
	}
	
	
}

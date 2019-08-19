package com.my.dolduck.model.dto;

public class StarDto {
	
		   private String name;
		   private String img;

		   public StarDto() {
		      super();
		   }
		   public StarDto(String name, String img) {
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

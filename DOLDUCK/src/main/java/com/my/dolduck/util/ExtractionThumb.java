package com.my.dolduck.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ExtractionThumb {
	
	public String makeThumbnail(String path, String filePath, String fileName, String fileExt) throws IOException {
		
		
	    // 원본 이미지 입니다.
	    BufferedImage srcImg = ImageIO.read(new File(filePath));

	    // 썸네일 크기 입니다.
	    int dw = 450, dh = 270;
		
	    // 원본이미지 크기 입니다.
	    int ow = srcImg.getWidth();
	    int oh = srcImg.getHeight();
		
	    // 늘어날 길이를 계산하여 패딩합니다.
	    int pd = 0;
	    if(ow > oh) {
	 	pd = (int)(Math.abs((dh * ow / (double)dw) - oh) / 2d);
	    } else {
		pd = (int)(Math.abs((dw * oh / (double)dh) - ow) / 2d);
	    }
	    srcImg = Scalr.pad(srcImg, pd, Color.WHITE, Scalr.OP_ANTIALIAS);
		
	    // 이미지 크기가 변경되었으므로 다시 구합니다.
	    ow = srcImg.getWidth();
	    oh = srcImg.getHeight();
		
	    // 썸네일 비율로 크롭할 크기를 구합니다.
	    int nw = ow;
	    int nh = (ow * dh) / dw;
	    if(nh > oh) {
		nw = (oh * dw) / dh;
		nh = oh;
	    }
		
	    // 늘려진 이미지의 중앙을 썸네일 비율로 크롭 합니다.
	    BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		
	    // 리사이즈(썸네일 생성)
	    BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
		
	    // 이미지 출력
	    String thumbName = path + "THUMB_" + fileName;
	    File thumbFile = new File(thumbName);
	    ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
	    
	    return thumbName;
	}

}

package com.lopina.exercises.chapter5.question8;

import com.lopina.exercises.chapter5.BitUtils;

public class ScreenCanvas {
	private int width;
	private int height;
	
	private byte[] canvas;
	
	public ScreenCanvas(int width, int height) {
		this.width = width;
		this.height = height;
		canvas = new byte[width * height / 8];
	}
	
	public int getWidth() {
		return width;
	}
	
	public void drawLine(int x1, int x2, int y) {
		int bytesPerRow = width / 8;
		
		int startByteIndex = y * bytesPerRow + (x1 / 8);
		int endByteIndex = y * bytesPerRow + (x2 / 8);
		
		for (int byteIndex = startByteIndex; byteIndex <= endByteIndex; byteIndex++) {
			byte mask = (byte) 0xFF;
			if (byteIndex == startByteIndex) {
				int edgeIndex = 7 - (x1 % 8);
				mask &= (((1 << (edgeIndex + 1)) - 1) & 0xFF);
			}
			
			if (byteIndex == endByteIndex) {
				int edgeIndex = 7 - (x2 % 8);
				mask &= ((~((1 << edgeIndex) - 1)) & 0xFF);
			}
			
			canvas[byteIndex] |= mask;
		}
	}
	
	@Override
	public String toString() {
		int bytesPerRow = width / 8;
		int height = canvas.length / bytesPerRow;
		
		StringBuilder sb = new StringBuilder();
		
		for (int h = 0; h < height; h++) {
			for (int b = 0; b < bytesPerRow; b++) {
				sb.append(BitUtils.byteToString(canvas[h * bytesPerRow + b]));
				sb.append("|");
			}
			sb.append("\n");
			for (int i = 0; i < width; i++) {
				sb.append("-");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}

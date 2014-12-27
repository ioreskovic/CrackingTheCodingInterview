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
		int height = canvas.length / bytesPerRow;
		
		int startByteIndex = y * bytesPerRow + (x1 / 8);
		int endByteIndex = y * bytesPerRow + (x2 / 8);
		
		System.out.println("sbi = " + startByteIndex);
		System.out.println("ebi = " + endByteIndex);
		
		int bytesToFill = x2 - x1 + 1;
		
		for (int byteIndex = startByteIndex; byteIndex <= endByteIndex; byteIndex++) {
			if (bytesToFill <= 0) {
				return;
			}
			
			
			if (byteIndex == startByteIndex) {
				int bitSetIndexEnd = 8 - (x1 % 8) - 1;
				int bitSetIndexStart = Math.max(bitSetIndexEnd - bytesToFill + 1, 0);
				int currentBytesToFill = bitSetIndexEnd - bitSetIndexStart + 1;
				
				byte mask = (byte) ((((1 << currentBytesToFill) - 1) << bitSetIndexStart) & 0xFF);
				canvas[byteIndex] |= mask;
				
				bytesToFill -= currentBytesToFill;
			}
			
			if (byteIndex > startByteIndex && byteIndex < endByteIndex) {
				canvas[byteIndex] = (byte) 0xFF;
				
				bytesToFill -= 8;
			}
			
			if (byteIndex == endByteIndex) {
				int bitClearIndex = 8 - (bytesToFill);
				byte mask = (byte) ((~((1 << (bitClearIndex)) - 1)) & 0xFF);
				canvas[byteIndex] |= mask;
			}
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

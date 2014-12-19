package com.lopina.util.compression.lzw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import edu.princeton.cs.introcs.Stopwatch;

public class LZWOutputStreamTest {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		for (char c1 = 'A'; c1 <= 'Z'; c1++) {
			for (char c2 = 'A'; c2 <= 'Z'; c2++) {
				sb.append(c1).append(c2);
			}
		}
		
		Random random = new Random();
		
		for (int i = 0; i < 1024*1024; i++) {
			sb.append((char) (65 + random.nextInt(26)));
		}
		
		FileOutputStream fos = new FileOutputStream(new File("bigTextNotCompressed.txt"));
		fos.write(sb.toString().getBytes());
		fos.close();
		
		Stopwatch stopwatch = new Stopwatch();
		FileInputStream originalFileInputStream = new FileInputStream(new File("bigTextNotCompressed.txt"));
		LZWDeflateOutputStream lzwdos = new LZWDeflateOutputStream(new FileOutputStream(new File("bigTextCompressed.txt")));
		
		lzwdos.write(originalFileInputStream);
		System.out.println("Compression time: " + stopwatch.elapsedTime());
		
		stopwatch = new Stopwatch();
		FileInputStream compressedFileInputStream = new FileInputStream(new File("bigTextCompressed.txt"));
		LZWInflateOutputStream lzwios = new LZWInflateOutputStream(new FileOutputStream(new File("bigTextDeCompressed.txt")));
		
		lzwios.write(compressedFileInputStream);
		System.out.println("Decompression time: " + stopwatch.elapsedTime());
	}
}

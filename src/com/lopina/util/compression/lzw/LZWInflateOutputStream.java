package com.lopina.util.compression.lzw;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.lopina.util.compression.CompressionCoder;

public class LZWInflateOutputStream extends OutputStream {

	private final OutputStream os;
	private final CompressionCoder inflater;
	
	public LZWInflateOutputStream(OutputStream os) {
		this.os = os;
		this.inflater = new LZWCompressionCoder();
	}
	
	@Override
	public void write(int i) throws IOException {
		this.inflater.inflate(i, this.os);
	}
	
	public void write(InputStream is) throws IOException {
		this.inflater.inflate(is, this.os);
	}

}

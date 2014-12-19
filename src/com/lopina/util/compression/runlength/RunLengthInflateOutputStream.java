package com.lopina.util.compression.runlength;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.lopina.util.compression.CompressionCoder;

public class RunLengthInflateOutputStream extends OutputStream {
	
	private OutputStream os;
	private CompressionCoder inflater;
	
	public RunLengthInflateOutputStream(OutputStream os) {
		this.os = os;
		this.inflater = new RunLengthCompressionProvider();
	}

	@Override
	public void write(int i) throws IOException {
		this.inflater.inflate(i, this.os);
	}
	
	public void write(InputStream is) throws IOException {
		this.inflater.inflate(is, this.os);
	}
}

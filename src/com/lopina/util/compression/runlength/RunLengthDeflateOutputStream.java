package com.lopina.util.compression.runlength;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.lopina.util.compression.CompressionCoder;

public class RunLengthDeflateOutputStream extends OutputStream {

	private OutputStream os;
	private CompressionCoder deflater;
	
	public RunLengthDeflateOutputStream(OutputStream os) {
		this.os = os;
		this.deflater = new RunLengthCompressionProvider();
	}
	
	@Override
	public void write(int i) throws IOException {
		this.deflater.deflate(i, this.os);
	}
	
	public void write(InputStream is) throws IOException {
		this.deflater.deflate(is, this.os);
	}

}

package com.lopina.util.compression.lzw;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.lopina.util.compression.CompressionCoder;

public class LZWDeflateOutputStream extends OutputStream {

	private final OutputStream os;
	private final CompressionCoder deflater;
	
	public LZWDeflateOutputStream(OutputStream os) {
		this.os = os;
		this.deflater = new LZWCompressionCoder();
	}
	
	@Override
	public void write(int i) throws IOException {
		this.deflater.deflate(i, this.os);
	}
	
	public void write(InputStream is) throws IOException {
		this.deflater.deflate(is, this.os);
	}

}

package com.lopina.util.compression;

import java.io.InputStream;
import java.io.OutputStream;

public interface CompressionCoder {
	public void inflate(InputStream is, OutputStream os);
	public void inflate(int i, OutputStream os);
	public void deflate(InputStream is, OutputStream os);
	public void deflate(int i, OutputStream os);
}

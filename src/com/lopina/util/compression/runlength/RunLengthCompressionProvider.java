package com.lopina.util.compression.runlength;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import com.lopina.util.compression.CompressionCoder;

import edu.princeton.cs.introcs.BinaryIn;
import edu.princeton.cs.introcs.BinaryOut;

public class RunLengthCompressionProvider implements CompressionCoder {

	private static final int R = 256;
	private static final int lgR = 8;
	
	private boolean old = false;
	
	@Override
	public void inflate(InputStream is, OutputStream os) {
		BinaryIn bis = new BinaryIn(is);
		BinaryOut bos = new BinaryOut(os);
		
		boolean bit = false;
		
		while (!bis.isEmpty()) {
			int run = bis.readInt(lgR);
			for (int i = 0; i < run; i++) {
				bos.write(bit);
			}
			bit = !bit;
		}
		
		bos.close();
	}
	
	public void inflate(int i, OutputStream os) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(i);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(bb.array());
		inflate(bais, os);
	}

	@Override
	public void deflate(InputStream is, OutputStream os) {
		char run = 0;
		
		BinaryIn bis = new BinaryIn(is);
		BinaryOut bos = new BinaryOut(os);
		
		while (!bis.isEmpty()) {
			boolean b = bis.readBoolean();
			if (b != old) {
				bos.write(run, lgR);
				run = 1;
				old = !old;
			} else {
				if (run == R - 1) {
					bos.write(run, lgR);
					run = 0;
					bos.write(run, lgR);
				}
				run ++;
			}
		}
		
		bos.write(run, lgR);
		bos.close();
	}
	
	public void deflate(int i, OutputStream os) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(i);
		ByteArrayInputStream bais = new ByteArrayInputStream(bb.array());
		
		deflate(bais, os);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream originalFileInputStream = new FileInputStream(new File("q64x96.bin"));
		FileOutputStream compressedFileOutputStream = new FileOutputStream(new File("q64x96-compressed.bin"));
		FileInputStream compressedFileInputStream = new FileInputStream(new File("q64x96-compressed.bin"));
		FileOutputStream decompressedFileOutputStream = new FileOutputStream(new File("q64x96-decompressed.bin"));
		
		RunLengthCompressionProvider rlc = new RunLengthCompressionProvider();
		rlc.deflate(originalFileInputStream, compressedFileOutputStream);
		rlc.inflate(compressedFileInputStream, decompressedFileOutputStream);
	}

}

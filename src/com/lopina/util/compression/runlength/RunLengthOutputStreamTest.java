package com.lopina.util.compression.runlength;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RunLengthOutputStreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream originalFileInputStream = new FileInputStream(new File("q64x96.bin"));
		RunLengthDeflateOutputStream rldos = new RunLengthDeflateOutputStream(new FileOutputStream(new File("compressed.bin")));
		
		rldos.write(originalFileInputStream);
		
		FileInputStream compressedFileInputStream = new FileInputStream(new File("compressed.bin"));
		RunLengthInflateOutputStream rlios = new RunLengthInflateOutputStream(new FileOutputStream(new File("decompressed.bin")));
		
		rlios.write(compressedFileInputStream);
	}
}

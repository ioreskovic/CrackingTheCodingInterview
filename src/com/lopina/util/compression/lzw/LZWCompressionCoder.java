package com.lopina.util.compression.lzw;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import com.lopina.exercises.chapter4.TST;
import com.lopina.util.compression.CompressionCoder;

import edu.princeton.cs.introcs.BinaryIn;
import edu.princeton.cs.introcs.BinaryOut;

public class LZWCompressionCoder implements CompressionCoder {

	private static final int R = 256;        // number of input chars
    private static final int L = 4096;       // number of codewords = 2^W
    private static final int W = 12;         // codeword width
	
	@Override
	public void inflate(InputStream is, OutputStream os) {
		BinaryIn bis = new BinaryIn(is);
		BinaryOut bos = new BinaryOut(os);
		
		String[] st = new String[L];
        int i; // next available codeword value

        // initialize symbol table with all 1-character strings
        for (i = 0; i < R; i++)
            st[i] = "" + (char) i;
        st[i++] = "";                        // (unused) lookahead for EOF

        int codeword = bis.readInt(W);
        if (codeword == R) return;           // expanded message is empty string
        String val = st[codeword];

        while (true) {
        	bos.write(val);
            codeword = bis.readInt(W);
            if (codeword == R) break;
            String s = st[codeword];
            if (i == codeword) s = val + val.charAt(0);   // special case hack
            if (i < L) st[i++] = val + s.charAt(0);
            val = s;
        }
        bos.close();
	}

	@Override
	public void inflate(int i, OutputStream os) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(i);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(bb.array());
		inflate(bais, os);
	}

	@Override
	public void deflate(InputStream is, OutputStream os) {
		BinaryIn bis = new BinaryIn(is);
		BinaryOut bos = new BinaryOut(os);
		
		String input = bis.readString();
		TST<Integer> st = new TST<Integer>();
		
		for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R+1;  // R is codeword for EOF

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);  // Find max prefix match s.
            bos.write(st.get(s), W);      // Print s's encoding.
            int t = s.length();
            if (t < input.length() && code < L)    // Add s to symbol table.
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t);            // Scan past s in input.
        }
        bos.write(R, W);
        bos.close();
	}

	@Override
	public void deflate(int i, OutputStream os) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(i);
		ByteArrayInputStream bais = new ByteArrayInputStream(bb.array());
		
		deflate(bais, os);
	}

}

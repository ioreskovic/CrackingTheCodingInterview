package com.lopina.exercises.dynamic.stringalignment;

import java.util.ArrayList;
import java.util.List;

public class DNANucleobaseAlphabet implements Alphabet {

	private static final List<Character> dnaNucleobaseAlphabetElements;
	
	static {
		dnaNucleobaseAlphabetElements = new ArrayList<Character>();
		
		dnaNucleobaseAlphabetElements.add('A');
		dnaNucleobaseAlphabetElements.add('C');
		dnaNucleobaseAlphabetElements.add('G');
		dnaNucleobaseAlphabetElements.add('T');
		dnaNucleobaseAlphabetElements.add(' ');
	}
	
	@Override
	public List<Character> getAlphabetElements() {
		return dnaNucleobaseAlphabetElements;
	}

}

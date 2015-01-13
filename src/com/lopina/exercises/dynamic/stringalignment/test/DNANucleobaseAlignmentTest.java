package com.lopina.exercises.dynamic.stringalignment.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.dynamic.stringalignment.DNANucleobaseAlignmentPenalty;
import com.lopina.exercises.dynamic.stringalignment.DNANucleobaseAlphabet;
import com.lopina.exercises.dynamic.stringalignment.DNANucleobaseStringAlignmentProblem;

public class DNANucleobaseAlignmentTest {
	DNANucleobaseAlignmentPenalty penaltyStrategy = new DNANucleobaseAlignmentPenalty(new DNANucleobaseAlphabet());
	
	String firstString;
	String secondString;
	
	String firstStringAligned;
	String secondStringAligned;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void test() {
		firstString = "AGTCGTGACTGGCGATAGAAAC";
		secondString = "TGACGCCAAAT";
		
		DNANucleobaseStringAlignmentProblem problem = new DNANucleobaseStringAlignmentProblem(penaltyStrategy, firstString, secondString);
		problem.solve();
		
		firstStringAligned = problem.getFirstString();
		secondStringAligned = problem.getSecondString();
		
		printProblem(firstString, secondString, firstStringAligned, secondStringAligned);
	}
	
	@Test
	public void smallTest() {
		firstString = "ACTG";
		secondString = "CTG";
		
		DNANucleobaseStringAlignmentProblem problem = new DNANucleobaseStringAlignmentProblem(penaltyStrategy, firstString, secondString);
		problem.solve();
		
		firstStringAligned = problem.getFirstString();
		secondStringAligned = problem.getSecondString();
		
		printProblem(firstString, secondString, firstStringAligned, secondStringAligned);
	}
	
	@Test
	public void bigTest() {
		this.firstString = "ACAAGATGCCATTGTCCCCCGGCCTCCTGCTGCTGCTGCTCTCCGGGGCCACGGCCACCGCTGCCCTGCCCCTGGAGGGTGGCCCCACCGGCCGAGACAGCGAGCATATGCAGGAAGCGGCAGGAATAAGGAAAAGCAGCCTCCTGACTTTCCTCGCTTGGTGGTTTGAGTGGACCTCCCAGGCCAGTGCCGGGCCCCTCATAGGAGAGGAAGCTCGGGAGGTGGCCAGGCGGCAGGAAGGCGCACCCCCCCAGCAATCCGCGCGCCGGGACAGAATGCCCTGCAGGAACTTCTTCTGGAAGACCTTCTCCTCCTGCAAATAAAACCTCACCCATGAATGCTCACGCAAGTTTAATTACAGACCTGAA";
		this.secondString = "ACAGCCACCGCTGCAGCTGC";
		
		DNANucleobaseStringAlignmentProblem problem = new DNANucleobaseStringAlignmentProblem(penaltyStrategy, firstString, secondString);
		problem.solve();
		
		firstStringAligned = problem.getFirstString();
		secondStringAligned = problem.getSecondString();
		
		printProblem(firstString, secondString, firstStringAligned, secondStringAligned);
	}

	private void printProblem(String firstString, String secondString, String firstStringAligned, String secondStringAligned) {
		System.out.println("Original problem:");
		System.out.println("\t" + "|" + firstString + "|");
		System.out.println("\t" + "|" + secondString + "|");
		System.out.println();
		System.out.println("Solved problem:");
		System.out.println("\t" + "|" + firstStringAligned + "|");
		System.out.println("\t" + "|" + secondStringAligned + "|");
	}

}

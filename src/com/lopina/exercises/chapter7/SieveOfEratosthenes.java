package com.lopina.exercises.chapter7;

import java.util.Arrays;

import edu.princeton.cs.introcs.Stopwatch;

public class SieveOfEratosthenes {
	private boolean[] flags;
	
	private static SieveOfEratosthenes INSTANCE = null;
	
	private SieveOfEratosthenes() {
	}
	
	public static SieveOfEratosthenes instance() {
		if (INSTANCE == null) {
			INSTANCE = new SieveOfEratosthenes();
		}
		
		return INSTANCE;
	}
	
	public static boolean isPrime(int n) {
		return SieveOfEratosthenes.instance().getSieve(n)[n];
	}
	
	public boolean[] getSieve(int n) {
		if (flags == null) {
			computeFlags(n);
			return flags;
		} else {
			if (flags.length >= (n + 1)) {
				return subflagsFor(n);
			} else {
				computeExpand(n);
				return flags;
			}
		}
	}

	private void computeFlags(int n) {
		this.flags = new boolean[n + 1];
		int startIndex = 0;
		int endIndex = n + 1;
		
		crossOffPrimeMultiples(n, startIndex, endIndex);
	}

	private void crossOffPrimeMultiples(int n, int startIndex, int endIndex) {
		initFlags(flags, startIndex, endIndex);
		int prime = 2;
		
		while (prime <= Math.sqrt(n)) {
			crossOff(flags, 0, n + 1, prime);
			prime = getNextPrime(flags, prime);
			
			if (prime >= flags.length) {
				break;
			}
		}
	}

	private int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		
		while (next < flags.length && !flags[next]) {
			next++;
		}
		
		return next;
	}

	private void crossOff(boolean[] flags, int from, int to, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	private void initFlags(boolean[] flags, int from, int to) {
		from = Math.max(2, from);
		for (int i = from; i < to; i++) {
			flags[i] = true;
		}
	}

	private boolean[] subflagsFor(int n) {
		return Arrays.copyOfRange(flags, 0, (n + 1) + 1);
	}

	private void computeExpand(int n) {
		boolean[] newFlags = Arrays.copyOf(flags, n + 1);
		int startIndex = flags.length;
		int endIndex = newFlags.length;
		flags = newFlags;
		
		crossOffPrimeMultiples(n, startIndex, endIndex);
	}
	
	public static void main(String[] args) {
//		Stopwatch stopwatch;
//		boolean[] primes;
//		double time;
//		int from;
//		int to;
//
//		from = 1999000;
//		to = 2000000;
//		stopwatch = new Stopwatch();
//		primes = SieveOfEratosthenes.instance().getSieve(to);
//		time = stopwatch.elapsedTime();
//		System.out.println("Fetched primes for n = " + to + " in " + time + " seconds.");
//		for (int i = from; i < primes.length; i++) {
//			if (primes[i]) {
//				System.out.print(i + " ");
//			}
//		}
//		System.out.println();
//		System.out.println();
//		
//		from = 999000;
//		to = 1000000;
//		stopwatch = new Stopwatch();
//		primes = SieveOfEratosthenes.instance().getSieve(to);
//		time = stopwatch.elapsedTime();
//		System.out.println("Fetched primes for n = " + to + " in " + time + " seconds.");
//		for (int i = from; i < primes.length; i++) {
//			if (primes[i]) {
//				System.out.print(i + " ");
//			}
//		}
//		System.out.println();
//		System.out.println();
		
		System.out.println("Is 999983 prime? " + SieveOfEratosthenes.isPrime(999983));
		System.out.println("Is 999007 prime? " + SieveOfEratosthenes.isPrime(999007));
		System.out.println("Is 999011 prime? " + SieveOfEratosthenes.isPrime(999011));
	}
}

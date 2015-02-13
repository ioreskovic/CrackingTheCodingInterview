package com.lopina.interview.google.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BiasedRandom {
	public static class Element {
		public Element(double p, String name) {
			this.p = p;
			this.name = name;
		}
		
		public double p;
		public String name;
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	public Element[] elements;
	public double[] cdf;
	private Random random;
	
	public BiasedRandom(Element[] elements) {
		this.elements = preProcess(elements);
		this.cdf = computeCdf(this.elements);
		this.random = new Random(System.currentTimeMillis());
	}

	private Element[] preProcess(Element[] elements) {
		List<Element> elems = new ArrayList<Element>();
		for (Element e : elements) {
			if (e.p >= 0.0 && e.p <= 1.0) {
				elems.add(e);
			}
		}
		
		return elems.toArray(new Element[elems.size()]);
	}

	private double[] computeCdf(Element[] elements) {
		double[] cfd = new double[elements.length];
		
		int index = 0;
		double psf = 0.0;
		
		while (index < elements.length) {
			cfd[index] = psf + elements[index].p;
			psf = cfd[index];
			index++;
		}
		
		return cfd;
	}
	
	public Element getNextBiasedRandom() {
		double pr = random.nextDouble();
		
		for (int i = 0; i < this.cdf.length; i++) {
			if (pr < cdf[i]) {
				return this.elements[i];
			}
		}
		
		return elements[elements.length - 1];
	}
	
	public static void main(String[] args) {
		Element[] elements = new Element[5];
		
		elements[0] = new Element(0.1, "P1");
		elements[1] = new Element(0.2, "P2");
		elements[2] = new Element(0.3, "P3");
		elements[3] = new Element(0.4, "P4");
		elements[4] = new Element(0.0, "P0");
		
		BiasedRandom br = new BiasedRandom(elements);
		
		Map<Element, Integer> counter = new HashMap<BiasedRandom.Element, Integer>();
		
		int k = 10000000;
		
		for (int i = 0; i < k; i++) {
			Element e = br.getNextBiasedRandom();
			int count = counter.getOrDefault(e, 0);
			count++;
			counter.put(e, count);
		}
		
		
		for (Element e : elements) {
			if (!counter.containsKey(e)) {
				counter.put(e, 0);
			}
			System.out.println(e + " pe=" + e.p + " vs po=" + counter.get(e) / (double) k);
		}
		
//		System.out.println(counter);
	}

}

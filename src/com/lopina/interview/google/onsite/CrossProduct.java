package com.lopina.interview.google.onsite;

import java.util.ArrayList;
import java.util.List;

public class CrossProduct {
	public static class Tuple<E> {
		public List<E> values = new ArrayList<E>();
		
		public void add(Tuple<E> tuple) {
			this.values.addAll(tuple.values);
		}
		
		public void add(E value) {
			this.values.add(value);
		}
		
		@Override
		public String toString() {
			return this.values.toString();
		}
	}
	
	public static <T> List<Tuple<T>> crossProduct(List<Tuple<T>> tupleList) {
		List<Tuple<T>> result = crossProduct(new Tuple<T>(), tupleList.get(0));
		
		for (int i = 1; i < tupleList.size(); i++) {
			result = crossProduct(result, tupleList.get(i));
		}
		
		return result;
	}
	
	public static <T> List<Tuple<T>> crossProduct(List<Tuple<T>> tupleList, Tuple<T> singleTuple) {
		List<Tuple<T>> result = new ArrayList<CrossProduct.Tuple<T>>();
		
		for (Tuple<T> tupleListElement : tupleList) {
			result.addAll(crossProduct(tupleListElement, singleTuple));
		}
		
		return result;
	}
	
	public static <T> List<Tuple<T>> crossProduct(Tuple<T> t1, Tuple<T> t2) {
		List<Tuple<T>> result = new ArrayList<CrossProduct.Tuple<T>>();
		
			for (T v2 : t2.values) {
				Tuple<T> resultTuple = new Tuple<T>();
				resultTuple.add(t1);
				resultTuple.add(v2);
				result.add(resultTuple);
			}
		
		return result;
	}
	
	public static <T> boolean canBeInCrossProductOf(Tuple<T> tuple, List<Tuple<T>> tupleList) {
		if (tuple.values.size() != tupleList.size()) {
			return false;
		}
		
		for (int i = 0; i < tuple.values.size(); i++) {
			T tupleValue = tuple.values.get(i);
			Tuple<T> origin = tupleList.get(i);
			
			if (!origin.values.contains(tupleValue)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Tuple<String> as = new Tuple<String>();
		as.add("A1");
		as.add("A2");
		
		Tuple<String> bs = new Tuple<String>();
		bs.add("B1");
		bs.add("B2");
		
		Tuple<String> cs = new Tuple<String>();
		cs.add("C1");
		cs.add("C2");
		
		Tuple<String> ds = new Tuple<String>();
		ds.add("D1");
		ds.add("D2");
		
		List<Tuple<String>> tuples = new ArrayList<CrossProduct.Tuple<String>>();
		tuples.add(as);
		tuples.add(bs);
		tuples.add(cs);
		tuples.add(ds);
		
		for (Tuple<String> tuple : crossProduct(tuples)) {
			System.out.println(tuple);
		}
		
		Tuple<String> testTuple = new Tuple<String>();
		testTuple.add("A1");
		testTuple.add("B2");
		testTuple.add("C1");
		testTuple.add("D2");
		
		System.out.println(canBeInCrossProductOf(testTuple, tuples));
	}
}

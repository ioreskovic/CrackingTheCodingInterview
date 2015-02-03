package com.lopina.interview.topcoder;

public class SortEstimate {
	public static double howMany(int c, int time) {
		double e = 1E-9;
		double threshhold = time / c;
		
		double low = 0;
		double high = time / c;
		double diff = high - low;
		
		while (diff > e) {
			System.out.println("Low: " + low + "; High: " + high + "; Diff: " + diff);
			double mid = (low + high) / 2;
			
			double nlogn = mid * Math.log(mid) / Math.log(2);
			
			if (nlogn > threshhold) {
				high = mid;
			} else {
				low = mid;
			}
			
			diff = high - low;
		}
		
		return low;
	}
	
	public static void main(String[] args) {
//		System.out.println(howMany(1, 8));
//		System.out.println(howMany(2, 16));
//		System.out.println(howMany(37, 12392342));
//		System.out.println(howMany(1, 2000000000));
	}
}

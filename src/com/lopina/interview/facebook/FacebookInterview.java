package com.lopina.interview.facebook;

import java.util.Arrays;

public class FacebookInterview {
	public static int[] addBinary(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        
        int[] c = new int[Math.max(aLength, bLength) + 1];
        int cLength = c.length;
        
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        int cIndex = cLength - 1;
        
        int carry = 0;
        
        while (aIndex >= 0 || bIndex >= 0) {
            int aValue = getOrDefault(a, aIndex, 0);
            int bValue = getOrDefault(b, bIndex, 0);
            
            int cValue = aValue + bValue + carry;
            
            if (cValue >= 2) {
                carry = cValue / 2;
                cValue = cValue % 2;
            } else {
                carry = 0;
            }
            
            c[cIndex] = cValue;
            
            aIndex--;
            bIndex--;
            cIndex--;
        }
        
        c[cIndex] = carry;
        
        return c;
    }
    
    private static int getOrDefault(int[] array, int index, int defaultValue) {
        if (index >= 0 && index < array.length) {
            return array[index];
        }
        
        return defaultValue;
    }
    
    public static void main(String[] args) {
		int[] a = new int[] {          1 };
		int[] b = new int[] {          0 };
		int[] c = addBinary(a, b);
		
		System.out.println(Arrays.toString(c));
	}
}

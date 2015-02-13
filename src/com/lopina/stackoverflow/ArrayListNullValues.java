package com.lopina.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class ArrayListNullValues {
	public static class Foo {
		public String s;
		
		public Foo(String s) {
			this.s = s;
		}
	}
	
	public static void main(String[] args) {
		List<Foo> bar = new ArrayList<Foo>();
		
		bar.add(null);
		bar.add(new Foo("0"));
		bar.add(new Foo("1"));
		bar.add(new Foo("2"));
		bar.add(new Foo("3"));
		
		System.out.println(ContainsAllNulls(bar));
	}
	
	public static <T> Boolean ContainsAllNulls(List<Foo> bar)
	{
	    if(bar != null &&  !bar.isEmpty() )
	    {
	       return bar .contains(null);
	    }

	    return true ;
	}
}

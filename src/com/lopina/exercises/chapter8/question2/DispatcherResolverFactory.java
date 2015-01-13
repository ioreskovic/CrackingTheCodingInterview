package com.lopina.exercises.chapter8.question2;

public class DispatcherResolverFactory {
	private DispatcherResolverFactory() {
	}
	
	public static DispatcherResolver create() {
		RespondentDispatcherResolver rdr = new RespondentDispatcherResolver();
		ManagerDispatcherResolver mdr = new ManagerDispatcherResolver();
		DirectorDispatcherResolver ddr = new DirectorDispatcherResolver();
		
		rdr.setNext(mdr);
		mdr.setNext(ddr);
		
		return rdr;
	}
}

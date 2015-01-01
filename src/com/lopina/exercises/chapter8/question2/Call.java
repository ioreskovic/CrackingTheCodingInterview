package com.lopina.exercises.chapter8.question2;

public class Call {
	private long id;
	private String query;
	
	public Call(long id, String query) {
		this.id = id;
		this.query = query;
	}
	
	public long getId() {
		return id;
	}
	
	public String getQuery() {
		return query;
	}
	
	@Override
	public String toString() {
		return "Call[" + id + ", " + query + "]";
	}
	
}

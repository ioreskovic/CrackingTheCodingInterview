package com.lopina.exercises.chapter8.question2;

import java.util.Random;

public abstract class Employee {
	protected String name;
	protected boolean available;
	protected double successChance;
	protected Random random;
	
	public Employee(String name, boolean available, Rank rank) {
		super();
		this.name = name;
		this.available = available;
		this.random = new Random();
		this.successChance = random.nextDouble();
	}
	
	public Employee(String name, boolean available, Rank rank, double successChanceFrom, double successChanceTo) {
		super();
		this.name = name;
		this.available = available;
		this.random = new Random();
		this.successChance = this.random.nextDouble() * (successChanceTo - successChanceTo) + successChanceFrom;
	}

	public Response tryHandle(Call call) {
		Response response = new Response(call);
		
		double roll = this.random.nextDouble();
		
		if (roll > this.successChance) {
			response.setHandled(false);
		} else {
			response.setHandled(true);
			response.setHandlingEmployee(this);
		}
		
		return response;
	}
	
	public void setBusy() {
		this.available = false;
	}
	
	public void setAvailable() {
		this.available = true;
	}
	
	public boolean isAvailable() {
		return this.available;
	}

	public static Employee create(Rank rank, String name, boolean available) {
		Employee employee = null;
		
		switch (rank) {
		case RESPONDENT:
			employee = new Respondent(name, available, rank.getLb(), rank.getUb());
			break;
			
		case MANAGER:
			employee = new Manager(name, available, rank.getLb(), rank.getUb());
			break;
			
		case DIRECTOR:
			employee = new Director(name, available, rank.getLb(), rank.getUb());
			break;
			
		default:
			break;
		}
		
		return employee;
	}
	
	@Override
	public String toString() {
		return "Employee[" + name + ", " + available + "]";
	}
}

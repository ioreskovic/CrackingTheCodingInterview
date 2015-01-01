package com.lopina.exercises.chapter8.question2;

public class Response {
	private final Call call;
	
	private boolean handled;
	private Employee handlingEmployee;
	
	public Response(Call call) {
		super();
		this.call = call;
	}
	
	public void setHandled(boolean handled) {
		this.handled = handled;
	}
	
	public void setHandlingEmployee(Employee handlingEmployee) {
		this.handlingEmployee = handlingEmployee;
	}
	
	public boolean isHandled() {
		return handled;
	}
	
	public Employee getHandlingEmployee() {
		return handlingEmployee;
	}
	
	public Call getCall() {
		return call;
	}
	
	@Override
	public String toString() {
		return "Response[" + call + ", " + handled + ", " + handlingEmployee + "]";
	}
	
}

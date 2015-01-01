package com.lopina.exercises.chapter8.question2;

public abstract class DispatcherResolver {
	protected DispatcherResolver next;
	protected Rank rank;
	
	protected DispatcherResolver(Rank rank) {
		this.rank = rank;
		this.next = EMPTY;
	}
	
	public Response handleCall(Call call) {
		Response response = handleCallInternal(call);
		
		if (!isHandled(response)) {
			System.out.println(rank + " could not handle " + call + ", sending to next level");
			response = this.next.handleCall(call);
		} else {
			System.out.println(call + " handled by " + rank);
		}
		
		return response;
	}
	
	private boolean isHandled(Response response) {
		return response.isHandled();
	}

	private Response handleCallInternal(Call call) {
		Response response = tryHandle(call);
		
		return response;
	}
	
	protected Response tryHandle(Call call) {
		Employee employee = EmployeeResourcePools.getFirstAvailable(this.rank);
		employee.setBusy();
		
		Response response = new Response(call);
		
		if (employee != null) {
			response = employee.tryHandle(call);
		}
		
		employee.setAvailable();
		return response;
	}
	
	public void setNext(DispatcherResolver next) {
		this.next = next;
	}
	
	public DispatcherResolver getNext() {
		return next;
	}
	
	private static DispatcherResolver EMPTY = new DispatcherResolver(null) {
		
		@Override
		public Response handleCall(Call call) {
			System.out.println("No more chain of command");
			return new Response(call);
		}
	};
}

package com.lopina.exercises.chapter8.question2;

import java.util.ArrayDeque;
import java.util.Deque;

public class CallDispatcherService {
	private static CallDispatcherService INSTANCE;
	
	private DispatcherResolver dispatcherResolver;
	private Deque<Call> unresolvedCalls;
	
	private CallDispatcherService() {
		this.dispatcherResolver = DispatcherResolverFactory.create();
		this.unresolvedCalls = new ArrayDeque<Call>();
	}
	
	public static CallDispatcherService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CallDispatcherService();
		}
		
		return INSTANCE;
	}
	
	public void dispatchCall(Call call) {
		System.out.println("Call");
		System.out.println("\t" + call);
		Response response = dispatcherResolver.handleCall(call);
		
		if (response == null || !response.isHandled()) {
			unresolvedCalls.offerLast(call);
			System.out.println("SCHEDULED");
		} else {
			System.out.println("RESOLVED");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CallDispatcherService cds = CallDispatcherService.getInstance();
		
		for (int i = 0; i < 48; i++) {
			Call call = new Call(i, "Call " + i);
			cds.dispatchCall(call);
		}
	}
}

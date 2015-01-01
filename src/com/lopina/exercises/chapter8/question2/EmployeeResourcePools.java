package com.lopina.exercises.chapter8.question2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class EmployeeResourcePools {

	private static Map<Rank, Deque<Employee>> queues;
	
	static {
		queues = new HashMap<Rank, Deque<Employee>>();
		
		createRespondents();
		createManagers();
		createDirectors();
	}
	
	public static Employee getFirstAvailable(Rank rank) {
		Deque<Employee> employees = queues.get(rank);
		
		for (Employee employee : employees) {
			if (employee.isAvailable()) {
				return employee;
			}
		}
		
		return null;
	}

	private static void createRespondents() {
		createEmployees(Rank.RESPONDENT);
	}

	private static void createManagers() {
		createEmployees(Rank.MANAGER);

	}

	private static void createDirectors() {
		createEmployees(Rank.DIRECTOR);

	}
	
	private static void createEmployees(Rank rank) {
		ArrayDeque<Employee> employees = new ArrayDeque<Employee>(rank.getNumberOf());
		for (int i = 0; i < rank.getNumberOf(); i++) {
			employees.offerLast(Employee.create(rank, rank + "[" + i + "]", true));
		}
		
		queues.put(rank, employees);
	}



}

package models;

import java.util.ArrayList;

import main.Util;

public class TodoList extends Task implements Timeable {

	private Integer priority;

	public TodoList(String taskName, String taskDesc, ArrayList<String> subtasks, Integer priority) {
		super(taskName, taskDesc, subtasks);
		this.priority = priority;
	}

	@Override
	public void view() {
		System.out.println("Task Name: " + this.getTaskName());
		System.out.println("Desc.    : " + this.getTaskDesc());
		System.out.println("Prio.    : " + priority);
		for (var i : this.getSubtasks()) {
			System.out.println("- " + i);
		}
	}

	@Override
	public void start() {
		while (true) {
			Util.cls();
			System.out.println("-----------TIMED SESSION-----------");
			System.out.println("Task Name: " + this.getTaskName());
			System.out.println("Desc.    : " + this.getTaskDesc());
			System.out.println("Prio.    : " + priority);
			for (var e : this.getSubtasks()) {
				System.out.println("- " + e);
			}
			System.out.println("-----------------------------------");

			long curr = System.currentTimeMillis();
			System.out.print("<TIMED SESSION> Press any key to stop timing...");
			Util.scanString();
			
			System.out.printf("[i] Total elapsed focus time: %d(s), good job!", (System.currentTimeMillis()-curr)/1000);
			
			if (!extend())
				break;
		}

	}

	@Override
	public Boolean extend() {
		String s = "";
		while (true) {
			System.out.println("\nSession complete! Do you wish to restart this session? [y/n]: ");
			s = Util.scanString();
			if (s.equalsIgnoreCase("n"))
				return false;
			else if (s.equalsIgnoreCase("y"))
				return true;
		}
	}

	@Override
	public void complete() {
		Util.cls();
		System.out.println("Daily commision complete.");
		System.out.println("+40 primogems.");
		System.out.println("[i] Task completed.");
		Util.pause();
	}

	// Setters and Getters
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}

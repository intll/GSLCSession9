package models;

import java.util.ArrayList;

import main.Util;

public class Goal extends Task{
	
	private String purpose;
	
	public Goal(String taskName, String taskDesc, ArrayList<String> subtasks, String purpose) {
		super(taskName, taskDesc, subtasks);
		this.purpose = purpose;
	}

	@Override
	public void view() {
		System.out.println("Task Name: " + this.getTaskName());
		System.out.println("Desc.    : " + this.getTaskDesc());
		System.out.println("Purp.    : " + purpose); 
		for (var i : this.getSubtasks()) {
			System.out.println("- " + i);
		}
	}

	@Override
	public void complete() {
		Util.cls();
		System.out.println("Planning ahead is like chess,");
		System.out.println("be wise in your decisions and you'll succeed.");
		System.out.println("[i] Task completed.");
		Util.pause();
	}
	
	//Setters and Getters
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}

package models;

import java.time.LocalDate;
import java.util.ArrayList;

import main.Util;

public class Deadline extends Task{
	
	//Deadlines are tasks that have end times. 
	LocalDate due;

	public Deadline(String taskName, String taskDesc, ArrayList<String> subtasks, LocalDate due) {
		super(taskName, taskDesc, subtasks);
		this.due = due;
	}

	@Override
	public void view() {
		System.out.println("Task Name: " + this.getTaskName());
		System.out.println("Desc.    : " + this.getTaskDesc());
		System.out.println("Due      : " + due.toString()); 
		for (var i : this.getSubtasks()) {
			System.out.println("- " + i);
		}
	}

	@Override
	public void complete() {
		Util.cls();
		System.out.println("The deadline comes... the deadlines goes...");
		System.out.println("Brain, procrastinate no more...");
		System.out.println("[i] Task completed.");
		Util.pause();
	}
	
	//Setters and Getters
	public LocalDate getDue() {
		return due;
	}

	public void setDue(LocalDate due) {
		this.due = due;
	}
	

}

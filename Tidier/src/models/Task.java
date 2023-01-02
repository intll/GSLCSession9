package models;

import java.util.ArrayList;

public abstract class Task {
	
	//The main abstract class that is the parent class of all tasks. 
	
	//Attributes
	private String taskID;
	private String taskName;
	private String taskDesc;
	private ArrayList<String> subtasks;
	
	//Constructor
	public Task(String taskName, String taskDesc, ArrayList<String> subtasks) {
		super();
		this.taskID = getTaskCode();
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.subtasks = subtasks;
	}

	//Methods
	public abstract void view();
	public abstract void complete();
	public String getTaskCode() {
		return this.getClass().getSimpleName().toUpperCase().substring(0, 2);
	}
	
	//Setters and Getters
	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public ArrayList<String> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(ArrayList<String> subtasks) {
		this.subtasks = subtasks;
	}

}

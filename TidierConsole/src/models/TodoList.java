package models;

import java.util.ArrayList;

public class TodoList extends Event {
	
	//Attributes
	private Integer priority;
	
	//Constructor
	public TodoList(String name, String desc, ArrayList<String> subtasks, Integer priority) {
		super(name, desc, subtasks);
		this.priority = priority;
	}

	//Methods
	@Override
	public void view() {
		System.out.println("--------- TODO ----------");
		System.out.println("ID      : " + this.getId());
		System.out.println("Name    : " + this.getName());
		System.out.println("Desc    : " + this.getDesc());
		System.out.println("Priority: " + this.getPriority());
		System.out.println("-------------------------");
		System.out.println("Subtasks: ");
		for (int i=0; i<this.getSubtasks().size(); ++i)
			System.out.println(this.getSubtasks().get(i));
		System.out.println("-------------------------");
	}

	@Override
	public void update() {
		
	}
	
	//Setters and Getters
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}

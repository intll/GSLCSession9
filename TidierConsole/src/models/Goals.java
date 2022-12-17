package models;

import java.util.ArrayList;

public class Goals extends Event {
	
	//Attributes
	private String purpose;
	
	//Constructor
	public Goals(String name, String desc, ArrayList<String> subtasks, String purpose) {
		super(name, desc, subtasks);
		this.purpose = purpose;
	}

	//Methods
	@Override
	public void view() {
		System.out.println("--------- GOAL ----------");
		System.out.println("ID     : " + this.getId());
		System.out.println("Name   : " + this.getName());
		System.out.println("Desc   : " + this.getDesc());
		System.out.println("Purpose: " + this.getPurpose());
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
	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
	
}

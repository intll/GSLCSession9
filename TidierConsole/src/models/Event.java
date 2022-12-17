package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Event {

	//Attributes
	private String id;
	private String name;
	private String desc;
	private ArrayList<String> subtasks;
	
	//Constructor
	public Event(String name, String desc, ArrayList<String> subtasks) {
		super();
		this.id = generateID();
		this.name = name;
		this.desc = desc;
		this.subtasks = subtasks;
	}
	
	//Methods
	public abstract void view();
	public abstract void update();
	
	protected String generateID() {
		Random rand = new Random();
		return this.getClass().getSimpleName().toUpperCase().substring(0, 1) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
	}

	//Setters and Getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ArrayList<String> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(ArrayList<String> subtasks) {
		this.subtasks = subtasks;
	}
	
}

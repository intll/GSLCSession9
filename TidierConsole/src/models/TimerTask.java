package models;

import java.util.ArrayList;

import main.Util;

public class TimerTask extends Event implements Timeable{
	
	//Attributes
	private Integer duration;
	
	//Constructor
	public TimerTask(String name, String desc, ArrayList<String> subtasks, Integer duration) {
		super(name, desc, subtasks);
		this.duration = duration;
	}

	//Methods
	@Override
	public void start() {
		int duration = this.duration;
		while (duration >= 0) {
			Util.cls();
			System.out.println("Name     : " + this.getName());
			System.out.println("Desc     : " + this.getDesc());
			System.out.println("Duration : " + this.getDuration());
			System.out.println("-------------------------");
			System.out.println("Subtasks: ");
			for (int i=0; i<this.getSubtasks().size(); ++i)
				System.out.println(this.getSubtasks().get(i));
			System.out.println();
			
			System.out.printf("Duration left: %d...", duration--);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Task cancelled.");
			}
			
		}
		System.out.println();
		System.out.println("[i] Task complete!");
	}

	@Override
	public void view() {
		System.out.println("--------- Timer ----------");
		System.out.println("ID       : " + this.getId());
		System.out.println("Name     : " + this.getName());
		System.out.println("Desc     : " + this.getDesc());
		System.out.println("Duration : " + this.getDuration());
		System.out.println("-------------------------");
		System.out.println("Subtasks: ");
		for (int i=0; i<this.getSubtasks().size(); ++i)
			System.out.println(this.getSubtasks().get(i));
		System.out.println("-------------------------");
		
		System.out.println("This is a timed task, do you wish to start it now? [Y to start]: ");
		String in = Util.scanString();
		if (in.toLowerCase().equals("y"))
			start();
	}
	
	@Override
	public Boolean extend() {
		return false;
	}

	@Override
	public void update() {
		
	}
	
	//Setters and Getters
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	
	
}

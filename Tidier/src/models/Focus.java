package models;

import java.util.ArrayList;

import main.Util;

public class Focus extends Task implements Timeable {

	private Integer durationSeconds;

	public Focus(String taskName, String taskDesc, ArrayList<String> subtasks, Integer durationSeconds) {
		super(taskName, taskDesc, subtasks);
		this.durationSeconds = durationSeconds;
	}

	@Override
	public void view() {
		System.out.println("Task Name: " + this.getTaskName());
		System.out.println("Desc.    : " + this.getTaskDesc());
		System.out.println("Time     : " + durationSeconds);
		for (var i : this.getSubtasks()) {
			System.out.println("- " + i);
		}
	}

	@Override
	public void complete() {
		Util.cls();
		System.out.println("Focus is the key to success.");
		System.out.println("Don't distract yourself.");
		System.out.println("[i] Task completed.");
		Util.pause();
	}

	@Override
	public void start() {

		String[] symbols = {"|", "/", "-", "\\"};
		while (true) {

			int d = durationSeconds;
			while (d >= 0) {
				for (int i=0; i<4; ++i) {
					Util.cls();
					System.out.println("-----------FOCUS SESSION-----------");
					System.out.println("Task Name: " + this.getTaskName());
					System.out.println("Desc.    : " + this.getTaskDesc());
					System.out.println("Time     : " + durationSeconds);
					for (var e : this.getSubtasks()) {
						System.out.println("- " + e);
					}
					System.out.println("-----------------------------------");
					
					System.out.printf("<FOCUS SESSION> %d(s) left %s...", d, symbols[i]);
					Util.sleep(250);
				}
				--d;
			}

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

	// Setters and Getters
	public Integer getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(Integer durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

}

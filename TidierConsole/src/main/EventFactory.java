package main;

import java.util.ArrayList;

import models.Goals;
import models.TimerTask;
import models.TodoList;

public class EventFactory {
	
	private String name;
	private String desc;
	private ArrayList<String> subtasks = new ArrayList<>();
	
	private void reset() {
		name = "";
		desc = "";
		subtasks.clear();
	}
	
	private void setBase() {
		reset();
		while (true) {
			System.out.print("Enter task name [1-15]: ");
			name = Util.scanString();
			if (name.length() >= 1 && name.length() <= 15)
				break;
		}
		
		while (true) {
			System.out.print("Enter a description for the task [1-50]: ");
			desc = Util.scanString();
			if (desc.length() >= 1 && desc.length() <= 50)
				break;
		}
		
		int nTasks = 0;
		while (true) {
			System.out.print("Enter number of subtasks [0-10]: ");
			nTasks = Util.scanInt();
			if (nTasks >=0 && nTasks <= 10)
				break;
		}
		
		for (int i=0; i<nTasks; ++i) {
			
			while (true) {
				String s = "";
				System.out.printf("Input description of subtask-%d [1-10]: ", i+1);
				s = Util.scanString();
				if (s.length() >= 1 && s.length() <= 10)
				{
					subtasks.add((i+1) + ". " + s);
					break;
				}
			}
			
		}
		
	}
	
	public TodoList createTL() {
		this.setBase();
		
		int priority = -1;
		while (true) {
			System.out.print("Enter the priority of this task [1 (less important) - 10 (very important)]: ");
			priority = Util.scanInt();
			
			if (priority >= 1 && priority <= 10)
				break;
		}
		
		return new TodoList(name, desc, subtasks, priority);
	}
	
	public Goals createGL() {
		this.setBase();
		
		String purpose = "";
		while (true) {
			System.out.print("Enter the purpose of this goal [1-20]: ");
			purpose = Util.scanString();
			
			if (purpose.length() >= 1 && purpose.length() <= 20)
				break;
		}
		
		return new Goals(name, desc, subtasks, purpose);
	}
	
	public TimerTask createTT() {
		this.setBase();
		
		Integer duration = -1;
		while (true) {
			System.out.print("How long should this task be? [>0 in seconds]: ");
			duration = Util.scanInt();
			
			if (duration > 0)
				break;
		}
		
		return new TimerTask(name, desc, subtasks, duration);
	}
}

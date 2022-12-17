package main;

import java.util.ArrayList;

import models.Event;

public class Main {
	
	private static ArrayList<Event> ev = new ArrayList<>();
	private static EventFactory ef = new EventFactory();
	
	public Main() {
		while (true) {
			Util.cls();
			System.out.println("_________________________             \r\n"
					         + "___  __/__(_)_____  /__(_)____________\r\n"
				             + "__  /  __  /_  __  /__  /_  _ \\_  ___/\r\n"
					         + "_  /   _  / / /_/ / _  / /  __/  /    \r\n"
					         + "/_/    /_/  \\__,_/  /_/  \\___//_/\n");
			System.out.println("[i] Tidier - A Simple Task Organizer");
			System.out.println("------------------------------------");
			System.out.println("1. View Tasks");
			System.out.println("2. Create Tasks");
			//System.out.println("3. Update Tasks");
			System.out.println("4. Exit");
			System.out.printf(">> ");
			
			int c = -1;
			c = Util.scanInt();
			
			switch (c) {
			case 1:
				viewTasks();
				break;
			case 2:
				createTask();
				break;
			case 3:
				break;
			case 4:
				System.exit(0);
				break;
			case 5:
				Util.cls();
				System.out.println("[i] See you!");
				System.exit(0);
			default:
				break;
			}
		}
	}
	
	public void viewTasks() {
		Util.cls();
		if (ev.isEmpty()) {
			System.out.println("No data...");
		}
		else {
			for (var i : ev)
				i.view();
		}
		Util.pause();
	}
	
	public void createTask() {
		while (true) {
			Util.cls();
			System.out.println("[i] What kind of task do you want to create?");
			System.out.println("1. Goals       (Long terms tasks with Purposes)");
			System.out.println("2. Todo-List   (Todo-Lists with Priorities)");
			//System.out.println("3. Daily Tasks (Repeating Daily Routines)");
			//System.out.println("4. Time Tasks  (Tasks with Durations)");
			System.out.println("5. Timer Tasks (Create focus sessions with timer tasks)");
			System.out.println("6. Back");
			System.out.println(">> ");
			
			int c = -1;
			c = Util.scanInt();
			
			switch (c) {
			case 1:
				Util.cls();
				ev.add(ef.createGL());
				System.out.println("[i] Goal created...");
				Util.pause();
				return;
			case 2:
				Util.cls();
				ev.add(ef.createTL());
				System.out.println("[i] Todo-List created...");
				Util.pause();
				return;
			case 3:
				break;
			case 4:
				break;
			case 5:
				Util.cls();
				ev.add(ef.createTT());
				System.out.println("[i] Timer Task created...");
				Util.pause();
				break;
			case 6:
				return;
			default:
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		new Main();
	}

}

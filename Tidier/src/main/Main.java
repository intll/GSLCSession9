package main;

import java.util.ArrayList;

import models.Deadline;
import models.Focus;
import models.Goal;
import models.Task;
import models.TaskFactory;
import models.TodoList;

public class Main {

	private String buildID = "0.2b";
	private ArrayList<Task> tasks = new ArrayList<>();
	private FileWalker fw = new FileWalker();

	public Main() {
		fw.readFile(tasks);
		while (true) {
			Util.cls();
			displayLogo();
			System.out.println("[i] Tidier Console - A Simple Task Organizer");
			System.out.println("--------------------------------------------");
			System.out.println("1. View Tasks");
			System.out.println("2. Create Tasks");
			System.out.println("3. Complete Tasks");
			System.out.println("4. About");
			System.out.println("5. Exit");
			System.out.println("--------------------------------------------");
			System.out.print(">> ");

			int c = Util.scanInt();
			switch (c) {
			case 1:
				viewTasks();
				break;
			case 2:
				createTasks();
				break;
			case 3:
				completeTasks();
				break;
			case 4:
				Util.cls();
				displayLogo();
				System.out.println("[i] Tidier " + buildID + " by Jason Adriel");
				Util.pause();
				break;
			case 5:
				Util.cls();
				System.out.print("[i] See you!");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	private void displayLogo() {
		System.out.println(" _______    ___        \n" + "/_  __(_)__/ (_)__ ____\n" + " / / / / _  / / -_) __/\n"
				+ "/_/ /_/\\_,_/_/\\__/_/\n");
	}

	private void createTasks() {
		while (true) {
			Util.cls();
			System.out.println("[i] What kind of task do you want to create?");
			System.out.println("--------------------------------------------");
			System.out.println("1. Deadline [Tasks with due dates]");
			System.out.println("2. TodoList [Daily todos]");
			System.out.println("3. Focus    [Time a focus session]");
			System.out.println("4. Goal     [Create long term plans]");
			System.out.println("5. Return");
			System.out.println("--------------------------------------------");
			System.out.print(">> ");

			int c = Util.scanInt();

			switch (c) {
			case 1:
				Util.cls();
				tasks.add(new TaskFactory().createDeadline());
				fw.writeFile(tasks);
				Util.pause();
				break;
			case 2:
				Util.cls();
				tasks.add(new TaskFactory().createTodoList());
				fw.writeFile(tasks);
				Util.pause();
				break;
			case 3:
				Util.cls();
				tasks.add(new TaskFactory().createFocus());
				fw.writeFile(tasks);
				Util.pause();
				break;
			case 4:
				Util.cls();
				tasks.add(new TaskFactory().createGoal());
				fw.writeFile(tasks);
				Util.pause();
				break;
			case 5:
				return;
			default:
				break;
			}
		}
	}

	public void viewTasks() {

		// Array preprocessing
		System.out.println("[i] Processing the index, please wait...");
		ArrayList<Task> allDeadlines = new ArrayList<>();
		ArrayList<Task> allFocus = new ArrayList<>();
		ArrayList<Task> allGoals = new ArrayList<>();
		ArrayList<Task> allTodos = new ArrayList<>();

		for (var i : tasks) {
			if (i instanceof Deadline)
				allDeadlines.add(i);
			else if (i instanceof Focus)
				allFocus.add(i);
			else if (i instanceof Goal)
				allGoals.add(i);
			else
				allTodos.add(i);
		}

		while (true) {
			Util.cls();
			System.out.println("[i] Apply a filter?");
			System.out.println("-------------------");
			System.out.println("1. View all");
			System.out.println("2. Deadlines only");
			System.out.println("3. Focus only");
			System.out.println("4. Goals only");
			System.out.println("5. Todo's only");
			System.out.println("6. Return");
			System.out.println("-------------------");
			System.out.print(">> ");

			int c = Util.scanInt();
			switch (c) {
			case 1:
				viewArray(tasks);
				Util.pause();
				break;
			case 2:
				viewArray(allDeadlines);
				Util.pause();
				break;
			case 3:
				viewArray(allFocus);
				startFocusSession(allFocus);
				break;
			case 4:
				viewArray(allGoals);
				Util.pause();
				break;
			case 5:
				viewArray(allTodos);
				startFocusSession(allTodos);
				break;
			case 6:
				return;
			default:
				break;
			}
		}
	}

	private void viewArray(ArrayList<Task> arr) {
		Util.cls();
		if (arr.isEmpty()) {
			System.out.println("[i] No tasks.");
		}
		for (int i = 0; i < arr.size(); ++i) {
			System.out.printf("-------------------------------%s%05d------------------------------\n",
					arr.get(i).getTaskCode(), i + 1);
			arr.get(i).view();
			System.out.println("---------------------------------------------------------------------\n");
		}
	}

	private void startFocusSession(ArrayList<Task> timeable) {
		if (!timeable.isEmpty()) {
			while (true) {
				System.out.printf("Do you wish to start a time session? [y/n]: ");
				String s = Util.scanString();

				if (s.equalsIgnoreCase("n"))
					return;
				else if (s.equalsIgnoreCase("y"))
					break;
			}

			while (true) {
				System.out.printf("Which task should be started? [1-%d]: ", timeable.size());
				int c = Util.scanInt();

				if (c >= 1 && c <= timeable.size()) {
					Task t = timeable.get(c - 1);
					if (t instanceof Focus) {
						((Focus) t).start();
						break;
					} else {
						((TodoList) t).start();
						break;
					}
				}
			}
		}
		else
		{
			Util.pause();
		}
	}

	public void completeTasks() {
		viewArray(tasks);
		
		if (tasks.isEmpty())
		{
			Util.pause();
			return;
		}
		
		int c = -1;
		while (true) {
			System.out.printf("Choose task to complete [1-%d]: ", tasks.size());
			c = Util.scanInt();
			if (c>=1 && c<=tasks.size())
				break;
		}
		
		tasks.get(c-1).complete();
		tasks.remove(c-1);
		fw.writeFile(tasks);
	}

	public static void main(String[] args) {
		new Main();
	}

}

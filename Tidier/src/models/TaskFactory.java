package models;

import java.time.LocalDate;
import java.util.ArrayList;

import main.Util;

public class TaskFactory {

	private String taskName;
	private String taskDesc;
	private ArrayList<String> subtasks = new ArrayList<>();
	
	private void info() {
		Util.cls();
		System.out.println("Task successfully created.");
	}

	private void createBaseline() {
		while (true) {
			System.out.print("Enter task name [1-15]: ");
			taskName = Util.scanString();

			if (taskName.length() >= 1 && taskName.length() <= 15)
				break;
		}

		while (true) {
			System.out.print("Enter a description for the task [1-50]: ");
			taskDesc = Util.scanString();
			if (taskDesc.length() >= 1 && taskDesc.length() <= 50)
				break;
		}

		int numberOfSubtasks = 0;
		while (true) {
			System.out.print("Enter number of subtasks [0-10]: ");
			numberOfSubtasks = Util.scanInt();
			if (numberOfSubtasks >= 0 && numberOfSubtasks <= 10)
				break;
		}

		for (int i = 0; i < numberOfSubtasks; ++i) {
			while (true) {
				String s = "";
				System.out.printf("Input a short description of subtask #%d [1-20]: ", i + 1);
				s = Util.scanString();
				if (s.length() >= 1 && s.length() <= 20) {
					subtasks.add(s);
					break;
				}
			}
		}
	}

	public Focus createFocus() {

		createBaseline();
		Integer duration = 0;
		while (true) {
			System.out.print("Enter the duration of the focus session [>0] [in seconds]: ");
			duration = Util.scanInt();
			if (duration > 0)
				break;
		}

		info();
		return new Focus(taskName, taskDesc, subtasks, duration);

	}

	public Goal createGoal() {

		createBaseline();
		String purpose = "";
		while (true) {
			System.out.print("Enter a motivating purpose of this long-term goal [1-30]: ");
			purpose = Util.scanString();
			if (purpose.length() >= 1 && purpose.length() <= 30)
				break;
		}

		info();
		return new Goal(taskName, taskDesc, subtasks, purpose);

	}

	public TodoList createTodoList() {

		createBaseline();
		Integer priority = 0;
		while (true) {
			System.out.print("Enter the priority of this task [1 (least important) - 10 (most important)]: ");
			priority = Util.scanInt();
			if (priority >= 1 && priority <= 10)
				break;
		}

		info();
		return new TodoList(taskName, taskDesc, subtasks, priority);

	}

	public Deadline createDeadline() {
		
		createBaseline();
		LocalDate due;
		
		while (true) {
			
			String input = "";
			System.out.printf("Enter the deadline of this task [yyyy-mm-dd]: ");
			input = Util.scanString();
			
			try {
				due = LocalDate.parse(input);
				if (!due.isBefore(LocalDate.now()))
					break;
			} catch (Exception e) {
				System.out.println("[!] The date is invalid.");
			}
			
		}
		
		info();
		return new Deadline(taskName, taskDesc, subtasks, due);
		
	}

}

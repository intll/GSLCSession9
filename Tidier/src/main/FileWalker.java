package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import models.Deadline;
import models.Focus;
import models.Goal;
import models.Task;
import models.TodoList;

public class FileWalker {

	// The files are written as
	// [TYPE]-[TASKNAME]-[TASKDESC]-[UNIQUEATTRIB]-[NSUBTASKS]-[SUBTASKS]

	private String fileName = "tasks.dat";

	public void readFile(ArrayList<Task> arr) {
		File data = new File(fileName);
		try {
			Scanner scan = new Scanner(data);
			while (scan.hasNextLine()) {
				String[] s = scan.nextLine().split("#");

				ArrayList<String> subtasks = new ArrayList<>();
				for (int i = 5; i < Integer.parseInt(s[4]) + 5; ++i) {
					subtasks.add(s[i]);
				}

				switch (s[0]) {
				case "DE":
					arr.add(new Deadline(s[1], s[2], subtasks, LocalDate.parse(s[3])));
					break;
				case "FO":
					arr.add(new Focus(s[1], s[2], subtasks, Integer.parseInt(s[3])));
					break;
				case "GO":
					arr.add(new Goal(s[1], s[2], subtasks, s[3]));
					break;
				case "TD":
					arr.add(new TodoList(s[1], s[2], subtasks, Integer.parseInt(s[3])));
					break;
				}
			}

			scan.close();
		} catch (FileNotFoundException e) {
			Util.cls();
			System.out.println("[!] Tasks.dat is missing... recreating a new one.");
			try {
				data.createNewFile();
			} catch (Exception e2) {
				System.out.println("[!] Fatal error: IO Exception");
			}
			Util.pause();
		}
	}

	public void writeFile(ArrayList<Task> arr) {
		FileWriter os;
		try {
			os = new FileWriter(fileName);

			for (var i : arr) {
				if (i instanceof Deadline) {
					Deadline e = (Deadline) i;
					os.append("DE" + "#" + e.getTaskName() + "#" + e.getTaskDesc() + "#" + e.getDue());
				} else if (i instanceof Focus) {
					Focus e = (Focus) i;
					os.append("FO" + "#" + e.getTaskName() + "#" + e.getTaskDesc() + "#" + e.getDurationSeconds());
				} else if (i instanceof Goal) {
					Goal e = (Goal) i;
					os.append("GO" + "#" + e.getTaskName() + "#" + e.getTaskDesc() + "#" + e.getPurpose());
				} else {
					TodoList e = (TodoList) i;
					os.append("TD" + "#" + e.getTaskName() + "#" + e.getTaskDesc() + "#" + e.getPriority());
				}
				Integer size = i.getSubtasks().size();
				os.append("#" + size.toString());
				for (var j : i.getSubtasks())
					os.append("#" + j);
				os.append(System.lineSeparator());
			}
			os.close();
		} catch (Exception e) {
			System.out.println("[!] Fatal error: IO Exception");
		}
		
		

	}

}

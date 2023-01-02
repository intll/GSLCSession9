#TidierConsole Project

Update 0.2b:
- Revamped the entire class system
- Added file access and saving features
- Added time features to TodoLists

Explanation of the Program:
The program consists of the following: 
1. Viewing Tasks 
2. Creating Tasks
3. Completing Tasks

View tasks allows you to filter out specific types of task that you want to see.
Creating tasks simply creates a specific type of task you want.
Completing tasks marks the task as complete and deletes it.

All tasks are saved automatically to a tasks.dat file.

Explanation of the class structure:
(main package)
1. FileWalker.java -> Handles file writing and reading. This is the main core that saves the tasks.dat file.

2. Main.java -> The main driver code.

3. Util.java -> Miscellaneous functions that are used throughtout the code.


(models package)
The tasks have a superclass abstract class of Task.java. This is the parent class of all the subclasses. 

Timeable.java is the interface that implements the timed tasks. Timed tasks are tasks that can be timed (either using a timer -> Focus tasks, or a stopwatch -> TodoList tasks).

Deadline.java, Focus.java, Goal.java, TodoList.java are various types of classes that have specific unique properties as explained in the task creation menu. 

TaskFactory.java is the main driver that implements the creation of the task and is responsible for the validation of user inputs and the creation of new tasks.

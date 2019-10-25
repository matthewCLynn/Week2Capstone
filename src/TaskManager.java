import java.util.ArrayList;
import java.util.Scanner;

//Matt Lynn

public class TaskManager {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Boolean quit = false;
		ArrayList<Task> allTasks = new ArrayList<>();
		System.out.println("Welcome to the Task Manager!");
		do {
			Task task = new Task();
			printMenu();
			int choice = Validator.getInt(scan, "\nWhat would you like to do? :", 1, 6);

			switch (choice) {
			// list tasks
			case 1:
				System.out.println("LIST TASKS\n\n");
				printList(allTasks);

				break;
			//list specific team member tasks 
			case 2:
				System.out.print("Team Member Name: ");
				int counter = 0;
				System.out.println("Done?\t\tDue Date\tTeam Member\tDescription\n");
				for(int i = 0; i<allTasks.size(); i++)
				{
					task=allTasks.get(i);
					if(task.getName().equalsIgnoreCase(scan.nextLine()))
					{
						counter++;
						
						System.out.println(counter + ". " + allTasks.get(i));
					}
				}
				
				break;
			// add task
			case 3:
//			allTasksClone = allTasks.clone();
				System.out.print("Team Member Name: ");
				task.setName(scan.nextLine());
				System.out.print("Task Description: ");
				task.setDescription(scan.nextLine());
				task.setdueDate(Validator.getStringMatchingRegex(scan, "Due Date (mm/dd/yyyy): ",
						"[0-1]\\d[/][0-3]\\d[/]\\d{4}"));

				allTasks.add(task);

				break;
			// remove task
			case 4:
				System.out.println("Which task would you like to delete?");
				printList(allTasks);
				System.out.println("0. Don't delete any tasks.");
				choice = Validator.getInt(scan, "", 0, allTasks.size());
				if (choice != 0)
				{
					System.out.println("Are you sure you want to delete task #" + choice + "?");
					System.out.println(choice + ". " + allTasks.get(choice - 1));
					if (Validator.getStringMatchingRegex(scan, "Delete (Y/N): ", "[YyNn]").equalsIgnoreCase("y"))
					allTasks.remove(choice - 1);
					
				}
				break;
			// complete task
			case 5:
				System.out.println("Which task would you like to mark complete?");
				printList(allTasks);
				System.out.println("0. Don't mark any tasks complete.");
				choice = Validator.getInt(scan, "", 0, allTasks.size());
				if (choice == 0)
					break;
				System.out.println("Are you sure you want to mark task #" + choice + " complete?");
				System.out.println(choice + ". " + allTasks.get(choice - 1));
				if (Validator.getStringMatchingRegex(scan, "Mark Complete (Y/N): ", "[YyNn]").equalsIgnoreCase("y")) {
					
					task = allTasks.get(choice - 1);
					task.setCompleted(true);
				}

				break;
			// exit
			case 6:
				
				if (Validator.getStringMatchingRegex(scan, "Are you sure you want to quit? (Y/N): ", "[YyNn]").equalsIgnoreCase("y"))
				{
					quit = true;
					System.out.println("Goodbye!");
				}
				break;
			}
		} while (quit == false);

	}

	public static void printMenu() {
		System.out.println("1.\t\tList Tasks");
		System.out.println("2.\t\tList tasks for Specific Member");
		System.out.println("3.\t\tAdd Task");
		System.out.println("4.\t\tDelete Task");
		System.out.println("5.\t\tMark Task Complete");
		System.out.println("6.\t\tQuit");

	}

	public static void printList(ArrayList<Task> allTasks) {
		System.out.println("Done?\t\tDue Date\tTeam Member\tDescription\n");

		for (int i = 0; i < allTasks.size(); i++) {
			System.out.println(i + 1 + ". " + allTasks.get(i));
		}
		System.out.println("\n");
	}

}

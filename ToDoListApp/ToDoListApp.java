import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> editTask();
                case 3 -> deleteTask();
                case 4 -> displayTasks();
                case 5 -> running = false;
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
        System.out.println("Exiting application. Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Edit Task");
        System.out.println("3. Delete Task");
        System.out.println("4. View Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter the new task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void editTask() {
        displayTasks();
        System.out.print("Enter the task number to edit: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (taskIndex > 0 && taskIndex <= tasks.size()) {
            System.out.print("Enter the new description: ");
            String newDescription = scanner.nextLine();
            tasks.set(taskIndex - 1, newDescription);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void deleteTask() {
        displayTasks();
        System.out.print("Enter the task number to delete: ");
        int taskIndex = scanner.nextInt();
        if (taskIndex > 0 && taskIndex <= tasks.size()) {
            tasks.remove(taskIndex - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTo-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

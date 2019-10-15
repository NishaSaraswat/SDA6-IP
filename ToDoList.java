package com.company;
import java.io.IOException;
import java.util.Scanner;

import static com.company.PrintMenu.printMenu;

public class ToDoList {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        TaskListActions taskAction = new TaskListActions();

        boolean quit = false;
        while (!quit) {
            printMenu();
            System.out.println("\nenter your choice: -> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    taskAction.addNewTask();
                    break;
                case 2:
                    taskAction.displayAllTasks();
                    break;
                case 3:
                    taskAction.displaySavedTasks();
                    break;
                case 4:
                    taskAction.displayUnsavedTasks();
                case 5:
                    // TODO: implement functionality for 'Edit A Task'
                case 6:
                    // TODO: implement functionality for 'Delete A Task'
                case 7:
                    taskAction.deleteAllTasks();
                    break;
                case 8:
                    taskAction.saveTasksToFile();
                    break;
                case 9:
                    System.out.println("\t\t\tWelcome back to main Menu:");
                    System.out.println("\t\t**********************************");
                    printMenu();
                    break;
                case 0:
                default:
                    quit = true;
                    System.out.println("Thank you for using Tasklist - See you next time");
                    break;
            }
        }
    }
}

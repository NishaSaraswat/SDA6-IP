package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;


public class ToDoList {
    private static Scanner scanner = new Scanner(System.in);
    private static Task myList = new Task();
    private static TaskList addTask = new TaskList();


    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printMenu();
        while (!quit) {
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    addTask.printList();
                    break;
                case 2:
                    addList();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    searchTask();
                    break;
                case 6:
                    quit = true;
                    addTask.printList();
                    System.out.println("\t\t\tWelcome back to main Menu:");
                    System.out.println("\t\t**********************************'");
                    printMenu();
                    break;


            }
        }

    }

    public static void printMenu() {
        //Display welcome
        System.out.print("Welcome to ToDoList" + " " + "(Date & Time:");
        //display today's date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss)");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("........................................................");

        /* System.out.print("you have x tasks todo and y tasks are done!"); */
        System.out.println("Pick an option");
        System.out.println("(1)Show Task List");
        //allow user to add new tasks
        System.out.println("(2)Add New Task");
        // Allow user to Edit
        System.out.println("(3)Edit Task:");
        System.out.println("(4)Remove");
        //mark as done
        //System.out.println("(5)mark as done");
        //remove task
        System.out.println("(5)Search");
        //save and quit
        System.out.println("(6)Save and Quit");
    }

    public static void addList() {
        System.out.print("Add Task Title :");
        myList.setTitle(scanner.nextLine());
        System.out.print("Enter project:");
        myList.setpProject(scanner.nextLine());
        myList.getProject();
        addTask.addList(myList.getTitle(),myList.getProject());
        //System.out.print("Enter Date:");
        //myList.setdDate(LocalDate.parse(scanner.nextLine()));
        //myList.getLocalDate();

    }
    public static void editTask() {
        System.out.println("Enter Task you want to edit:");
        int taskNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new task:");
        String newTask = scanner.nextLine();
        addTask.editTask(taskNo - 1, newTask);
    }
    public static void removeTask() {
        System.out.println("Enter Task you want to remove:");
        int taskNo = scanner.nextInt();
        scanner.nextLine();
        addTask.removeTask(taskNo);
    }
    public static void searchTask() {
        System.out.println("Task title to search for:");
        String sTask = scanner.nextLine();
        if (addTask.searchTask(sTask) != null) {
            System.out.println("Found " + sTask + " in your list");
        } else {
            System.out.println(sTask + " is not in the list");
        }
    }
}


package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.AddTaskListToFile.addTasklistToFile;
import static com.company.Formatters.*;
import static com.company.GetTaskListFromFile.getTaskListFromFile;
import static com.company.UtilFunction.checkDate;
import static com.company.UtilFunction.getLocalDateFromString;

public class TaskListActions {

    private String taskTitle;
    private String projectType;
    private String dueDate;
    private LocalDate taskDueDate;


    private Scanner scanner = new Scanner(System.in);

    File todoFile = new File("resources/todolistfile.txt");

    // 'inputTaskList' will be used to temporarily store the Tasks.
    ArrayList<Task> inputTaskList = new ArrayList<>();

    // 'outputTaskList' will be used to temporarily store the Tasks received from 'objectInputStream'
    ArrayList<Task> outputTaskList = new ArrayList<>();

    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;

    // TODO: add exception handling at function level and remover from the default Constructor
    TaskListActions() throws IOException {
    }

    public void addNewTask() {

        System.out.println("Please add task title:");
        taskTitle = scanner.nextLine();
        System.out.println("Please add task type:");
        projectType = scanner.nextLine();
        System.out.println("Please enter task's due date (in 'DD/MM/YYYY' format):");
        dueDate = scanner.nextLine();
        while (!checkDate(dueDate)) {
            System.out.println("Please enter task's due date in correct format i.e. >> 'DD/MM/YYYY':");
            dueDate = scanner.nextLine();
        }
        taskDueDate = getLocalDateFromString(dueDate);

        Task taskToAdd = new Task(taskTitle, projectType, taskDueDate);
        inputTaskList.add(taskToAdd);
        System.out.println("\nYour task has been added. (Perform Save to store permanently). \n");

    }

    public void saveTasksToFile() throws IOException {

        getTaskListFromFile(outputTaskList, todoFile);

        // First fetching existing data from the file
        if (!outputTaskList.isEmpty()) {
            // Appending all Tasks from file at the bottom of 'inputTaskList'
            inputTaskList.addAll(outputTaskList);
        }

        if (inputTaskList.isEmpty()) {
            System.out.println("There is no Task to Save!");
        } else {
            addTasklistToFile(inputTaskList, todoFile);
        }
        // Deleting data from 'inputTaskList' after saving to the file.
        inputTaskList.clear();
        outputTaskList.clear();
    }

    public void displayUnsavedTasks() {

        if (inputTaskList.isEmpty()) {
            System.out.println("\nNOTE: >> There are no Unsaved Tasks \n");
        } else {
            System.out.println("\n* * Displaying UnSaved Tasks * * \n" + dashLine);
            System.out.format(formatter, "TaskTile", "TaskType", "TaskDueDate");
            System.out.println(hashLine);
            // iterating through each item in the 'inputTaskList'
            for (Task task : inputTaskList) {
                System.out.format(formatter, task.getTitle(), task.getProject(), task.getLocalDate());
            }
            System.out.println(dashLine);
        }
    }

    public void displaySavedTasks() throws IOException {

        getTaskListFromFile(outputTaskList, todoFile);

        if (outputTaskList.isEmpty()) {
            // Case: - When there is no task in the 'todoFile'
            System.out.println("* There are no Saved Tasks * \n");
        } else {
            System.out.println("\n* * Displaying Saved Tasks * * \n" + dashLine);
            System.out.format(formatter, "TaskTile", "TaskType", "TaskCreationDate", "TaskDueDate");
            System.out.println(hashLine);
            // Print tasks from the file
            for (Task task : outputTaskList) {
                System.out.format(formatter, task.getTitle(), task.getProject(), task.getLocalDate());
            }
            System.out.println(dashLine);
        }
        outputTaskList.clear();
    }

    public void displayAllTasks() throws IOException {
        displaySavedTasks();
        displayUnsavedTasks();
    }

    public void deleteAllTasks() throws IOException {
        new FileOutputStream(todoFile).close();
    }
}



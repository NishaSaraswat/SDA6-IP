package com.company;
import java.time.LocalDate;
import java.util.ArrayList;


public class TaskList {
    public TaskList() {

    }

    LocalDate date = LocalDate.now();
    //List for writing tasks to the file
    public ArrayList<String> inputTask = new ArrayList<String>();
    //List for reading tasks from the file
   /*public ArrayList<Task> outputTask = new ArrayList<Task>();
    File todoFile = new File("todolistfile.txt");

    for(int i=0;i<5 ; i++){

    }*/


    public Task addList(String title, String project) {
        Task t = new Task(title, project);

        inputTask.add(title);
        inputTask.add(project);
        //inputTask.add(String.valueOf(date));
        return t;
    }
//public int getNumberOfTasks(){
//return newTask.size();
//}

    public void printList() {
        System.out.println("You have" + " " + inputTask.size() + " tasks to do");
        for (int i = 0; i < inputTask.size(); i++) {
            System.out.println((i + 1) + "." + inputTask.get(i));
        }
    }

    public void editTask(int position, String newTask) {
        inputTask.set(position, newTask);
        System.out.println("Task " + (position + 1) + " has been edited");
    }

    public void removeTask(int position) {
        String theTask = inputTask.get(position);
        inputTask.remove(position);
    }


    public String searchTask(String searchByTille) {
        boolean have = inputTask.contains(searchByTille);
        int position = inputTask.indexOf(searchByTille);
        if (position >= 0) {
            return String.valueOf(inputTask.get(position));
        }
        return null;

    }
}


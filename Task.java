package com.company;
import java.io.Serializable;
import java.time.LocalDate;


public class Task implements Serializable {

    private String taskTitle;
    private String projectType;
    private LocalDate dueDate;


    Task(){

    }
    public Task(String taskTitle, String projectType, LocalDate dueDate) {

        this.taskTitle = taskTitle;
        this.projectType = projectType;
        this.dueDate = dueDate;

    }
    public String getTitle() {
        return taskTitle;
    }
    public void setTitle(String tTitle){
        this.taskTitle = tTitle;

    }
    public String getProject() {
        return projectType;
    }
    public void setpProject(String pProject) {
        this.projectType= pProject;
    }

    public LocalDate getLocalDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate)  {
        this.dueDate =dueDate;

    }

}





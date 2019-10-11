package com.company;
import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    private String tTitle;
    private String pProject;
    //private LocalDate dDate;

    Task(){

    }
    public Task(String tTitle, String pProject) {

        this.tTitle = tTitle;
        this.pProject = pProject;
        //this.dDate = dDate;
    }
    public String getTitle() {
        return tTitle;
    }
    public void setTitle(String tTitle){
        this.tTitle = tTitle;

    }
    public String getProject() {
        return pProject;
    }
    public void setpProject(String pProject) {
        this.pProject= pProject;
    }

    /*public LocalDate getLocalDate() {
        return dDate;
    }
    public void setdDate(LocalDate dDate) {

        this.dDate = dDate;
    }    */

}
package com.example.dell.movielist;

/**
 * Created by DELL on 10/19/2018.
 */

public class Movie {
    public String title;
    public double ranting;
    public int status;

    public Movie() {
    }

    public Movie(String title, double ranting, int status) {
        this.title = title;
        this.ranting = ranting;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getStatus() {
        if (status == 1) {
            return "playing";
        } else if (status == 2) {
            return "comming soon";
        } else
            return "Archive";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getRanting() {
        return ranting;
    }

    public void setRanting(double ranting) {
        this.ranting = ranting;
    }
}

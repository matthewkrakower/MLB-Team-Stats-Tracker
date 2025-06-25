package com.example.springboot;

import jakarta.persistence.Entity; //this tells Spring this class is a JPA entity and it will be mapped to a database table
import jakarta.persistence.Id; //there will be a primary key
import jakarta.persistence.GeneratedValue; //tells jpa how to generate values for the primary key automatically
import jakarta.persistence.GenerationType; //this auto increments the primary key

@Entity //entity is creating a table called BaseballPlayer
public class BaseballPlayer {

    @Id //this marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //essentially auto incrementing
    private Integer id; //the id itself, integer preferred to int

    private String player_name;
    private String url;

    private String batting_average;

    private String player_summary; //description

    public BaseballPlayer() {} //default constructor, required by JPA - creates a blank BaseballPlayer object first before we can fill it

    public BaseballPlayer(String player_name, String url, String batting_average, String player_summary) { //constructor for the actual values
        this.player_name = player_name;
        this.url = url;
        this.batting_average = batting_average;
        this.player_summary = player_summary;
    }

    //get the values. this is necessary to access the values
    public Integer getId() { //these names need to follow exactly what the variable names are
        return id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getUrl() {
        return url;
    }

    public String getBatting_average() {
        return batting_average;
    }

    public String getPlayer_summary() {
        return player_summary;
    }

    //set the values. this is necessary to modify values
    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBatting_average(String batting_average) {
        this.batting_average = batting_average;
    }

    public void setSummary(String player_summary) {
        this.player_summary = player_summary;
    }
}
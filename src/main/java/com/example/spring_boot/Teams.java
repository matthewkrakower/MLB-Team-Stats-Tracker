package com.example.springboot;

import jakarta.persistence.Entity; //this tells Spring this class is a JPA entity and it will be mapped to a database table
import jakarta.persistence.Id; //there will be a primary key
import jakarta.persistence.GeneratedValue; //tells jpa how to generate values for the primary key automatically
import jakarta.persistence.GenerationType; //this auto increments the primary key
import jakarta.persistence.Table; //so we can give the table a name
import jakarta.persistence.Column;

@Entity //entity is creating a table called BaseballPlayer
@Table(name = "teams")
//use @table to define the actual name of the table
public class Teams {

    //use @column to define the actual names of the columns
    @Id //this marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //essentially auto incrementing
    private Integer id; //the id itself, integer preferred to int

    @Column(name = "team")
    private String team;
    @Column(name = "wins")
    private Integer wins;

    @Column(name = "losses")
    private Integer losses;

    @Column(name = "win_percentage")
    private Double winPercentage;

    public Teams() {} //default constructor, required by JPA - creates a blank BaseballPlayer object first before we can fill it

    public Teams(String team, Integer wins, Integer losses, Double winPercentage) { //constructor for the actual values
        this.team = team;
        this.wins = wins;
        this.losses = losses;
        this.winPercentage = winPercentage;
    }

    //get the values. this is necessary to access the values
    public Integer getId() { //these names need to follow exactly what the variable names are
        return id;
    }

    public String getTeam() {
        return team;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    //set the values. this is necessary to modify values
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}

//git status to see what is new/edits
//git add . to stage
//git commit -m "INSERT MESSAGE HERE"
// git push --set-upstream origin main to push
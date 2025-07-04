package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired; //automatically provides my connected repo
import org.springframework.web.bind.annotation.*;
//holds @RestController, @RequestMapping, @GetMapping, @PostMapping, all of which help define web routes

import java.util.List; //importing lists so we can hold multiple baseballplayer objects at once

@RestController //this means that we will use REST API requests and return JSON data (instead of a webpage)
@RequestMapping("/teams") //this is the base url
public class TeamsController {

    @Autowired //this calls the BaseballPlayerRepo.java so we dont have to manually create an instance
    private TeamsRepo teamsrepo;
    //Declares a variable baseballplayerrepo so we can access the database using the methods in JpaRepository

    //get endpoint for the route /baseballplayer, this method runs when we run a get request in postman
    @GetMapping
    public List<Teams> getAllTeams() { //List<BaseballPlayer> meaning we will return a list of players
        return teamsrepo.findAll(); //finds all records from our table
    }

    //post endpoint for the route /webinfo, this method runs when we run a post request in postman
    @PostMapping
    //@RequestBody BaseballPlayer baseballPlayer: reads the JSON from the POST request body and converts it into a BaseballPlayer object
    public Teams createWebInfo(@RequestBody Teams team) {
        return teamsrepo.save(team); //this saves the player to the database and returns it
    }
}
package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository; //importing framework for jpa repo
import java.util.Optional;

//creates an interface that lets us easily save, update, delete, and find WebInfo objects
//<WebInfo, Long> means we are working with the BaseballPlayer class and the id field is an integer
public interface TeamsRepo extends JpaRepository<Teams, Integer> {
    // no code needed, CRUD methods are free
    Optional<Teams> findByTeam(String team); //used when we get from stats api
    //gives a custom, readable, auto-generated SQL query method that
    // simplifies and safely checks for a team’s existence which is essential for clean API-to-database syncing
    //SELECT * FROM teams WHERE team = ?;
    //essentially findByX looks for X in the Teams table. if its there, then update, else create.
}
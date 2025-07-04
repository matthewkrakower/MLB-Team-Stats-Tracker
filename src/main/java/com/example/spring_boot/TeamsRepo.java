package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository; //importing framework for jpa repo

//creates an interface that lets us easily save, update, delete, and find WebInfo objects
//<WebInfo, Long> means we are working with the BaseballPlayer class and the id field is an integer
public interface TeamsRepo extends JpaRepository<Teams, Integer> {
    // no code needed, CRUD methods are free
}
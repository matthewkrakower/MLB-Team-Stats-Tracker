package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
//lets Spring automatically inject a bean (like TeamsRepo) into your consumer class without manually instantiating it
import org.springframework.jms.annotation.JmsListener;
//to listen to the queue
import org.springframework.stereotype.Component;
//needed so Spring knows to manage this class and enable @JmsListener
//tells Spring to detect this class as a bean during component scanning
//bean = Java object that is managed by the Spring container

@Component
public class GameStatsConsumer {

    @Autowired
    private TeamStatsService teamStatsService; //custom service class to get what we need from stats API

    @JmsListener(destination = "gameStatsQueue") //we trigger the following method when there is a message in
    // "game.stats.queue"
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message); //print the message for debugging
        // message could be a game ID or just "update"
        teamStatsService.fetchAndUpdateTeamStats(message);
        //passes the message into the service layer (TeamStatsService) to actually do the data fetching and saving
    }
}
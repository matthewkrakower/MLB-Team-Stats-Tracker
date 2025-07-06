package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

@Service //this is a service class to fetch and save team stats
public class TeamStatsService {

    @Autowired
    private TeamsRepo teamsRepo; //has our data from the repo

    public void fetchAndUpdateTeamStats(String gameIdOrTrigger) { //gameIdOrTrigger is not currently being used, but could later
        String apiUrl = "https://statsapi.mlb.com/api/v1/standings?leagueId=103,104&season=2025&standingsTypes=regularSeason";

        RestTemplate restTemplate = new RestTemplate(); //new http client
        String response = restTemplate.getForObject(apiUrl, String.class); //get request to the API
        //response is a string of JSON
        JSONObject json = new JSONObject(response); //converts the response into a JSON object to parse

        JSONArray records = json.getJSONArray("records"); //the records array holds
        //division records, all holding team standings

        for (int i = 0; i < records.length(); i++) { //loop thru each division in the records array
            JSONObject record = records.getJSONObject(i); //gets the current division
            JSONArray teamRecords = record.getJSONArray("teamRecords"); //gets the individual team records inside of it

            for (int j = 0; j < teamRecords.length(); j++) { //for each team's record
                JSONObject teamRecord = teamRecords.getJSONObject(j); //get an individual team's record

                String team = teamRecord.getJSONObject("team").getString("name"); //get the team's name
                int wins = teamRecord.getJSONObject("leagueRecord").getInt("wins"); //get their wins
                int losses = teamRecord.getJSONObject("leagueRecord").getInt("losses"); //get their losses
                String winPercentage = teamRecord.getJSONObject("leagueRecord").getString("pct");

                Teams teamEntity = teamsRepo.findByTeam(team).orElse(new Teams()); //check if this team already exists in the db
                //if it does, load for update. If it doesn't, create a new empty Teams object.
                teamEntity.setTeam(team);
                teamEntity.setWins(wins);
                teamEntity.setLosses(losses);
                teamEntity.setWinPercentage(winPercentage);
                //sets or updates all the fields

                teamsRepo.save(teamEntity); //save this team in the teamsRepo
                //If it’s a new record, it gets inserted. If it already exists, it’s updated
            }
        }
    }
}
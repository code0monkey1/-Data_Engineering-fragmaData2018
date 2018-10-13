package utilities;

import model.Match;
import model.MatchResult;
import model.Team;
import model.TossDecision;

import java.io.*;
import java.util.*;

public class PopulateMatches {

    private Map<Integer, Match> idMatchMap;
    private Map<String, Team> nameTeamMap;


    public PopulateMatches(String fileName) {
        //initialise
        idMatchMap = new HashMap<>();
        nameTeamMap = new HashMap<>();


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
//            System.out.println("Started file processing");
            String line = "";
            boolean firstLine = true;

            while ((line = bufferedReader.readLine()) != null) {

                if (firstLine) {     //skip first line
                    firstLine = false;
                    continue;
                }
                // [0] MATCH_ID, [1] SEASON [2] CITY, [3] DATE, [4] TEAM1, [5] TEAM2,
                // [6] TOSS_WINNER, [7] TOSS_DECISION, [8] RESULT, [9] WINNER (optional)

                String matchEntry[] = line.split(",");

                if (matchEntry.length != 10) {

                    // deal with offByOne entry

                    String arr[] = Arrays.copyOf(matchEntry, matchEntry.length + 1);

                    matchEntry = arr;

                }

                int match_id = Integer.parseInt(matchEntry[0]);
                //  System.out.println("Debugging matchID :"+match_id);

                int season = Integer.parseInt(matchEntry[1]);
                String city = matchEntry[2];
                String date = matchEntry[3];
                String team1 = matchEntry[4];
                String team2 = matchEntry[5];
                String tossWinner = matchEntry[6];
                int tossDecision = processTossDecision(matchEntry[7]);
                int matchResult = processMatchResult(matchEntry[8]);
                String winner = matchEntry[9]; // optional


                Match match = new Match(match_id, season, city, date, team1, team2, tossWinner, tossDecision, matchResult, winner);
//                System.out.println(match);
                idMatchMap.put(match_id, match);
                addTeam(team1, match_id);
                addTeam(team2, match_id);
            }

        } catch (Exception e) {
            System.out.println("Exception while Populating matches");

        }
    }


    public Map<Integer, Match> getIdMatchMap() {
        return idMatchMap;
    }

    public Map<String, Team> getNameTeamMap() {
        return nameTeamMap;
    }

    private void addTeam(String teamName, int match_id) {
        // if team entry not present , create team
        if (!nameTeamMap.containsKey(teamName)) {
            Team tempTeam = new Team(teamName);
            nameTeamMap.put(teamName, tempTeam);
        }
        // add match_id
        Team team = nameTeamMap.get(teamName);
        team.addMatchID(match_id);
    }

    private int processTossDecision(String tossDecision) {
        tossDecision = tossDecision.trim();

        if (tossDecision.equals("field")) {
            return TossDecision.FIELD;
        } else return TossDecision.BAT;

    }

    private int processMatchResult(String matchResult) {
        matchResult = matchResult.trim();
        if (matchResult.equals("tie")) return MatchResult.TIE;
        else if (matchResult.equals("normal")) return MatchResult.NORMAL;
        return MatchResult.NORESULT;
    }
}

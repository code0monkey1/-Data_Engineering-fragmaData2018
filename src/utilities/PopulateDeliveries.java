package utilities;


import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PopulateDeliveries {

    private Map<Integer, Match> idMatchMap;


    public PopulateDeliveries(String fileName, Map<Integer, Match> idMatchMap) {
        this.idMatchMap = idMatchMap;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {

            String line = "";
            boolean firstLine = true;

            while ((line = bufferedReader.readLine()) != null) {

                if (firstLine) {     //skip first line
                    firstLine = false;
                    continue;
                }
//                System.out.println("Processing");
                String arr[] = line.split(",");

                // MATCH_ID, INNING, BATTING_TEAM, BOWLING_TEAM, OVER, BALL, BATSMAN, BOWLER, WIDE_RUNS, BYE_RUNS,  LEGBYE_RUNS, NOBALL_RUNS, PENALTY_RUNS, BATSMAN_RUNS, EXTRA_RUNS, TOTAL_RUNS;


                int matchID = Integer.parseInt(arr[0]);
                int inning = Integer.parseInt(arr[1]);
                String battingTeam = arr[2].trim();
                String ballingTeam = arr[3].trim();
                int over = Integer.parseInt(arr[4]);
                int ball = Integer.parseInt(arr[5]);
                String batsman = arr[6].trim();
                String baller = arr[7].trim();

                int varArr[] = new int[8];

                varArr[0] = Integer.parseInt(arr[8]);
                varArr[1] = Integer.parseInt(arr[9]);
                varArr[2] = Integer.parseInt(arr[10]);
                varArr[3] = Integer.parseInt(arr[11]);
                varArr[4] = Integer.parseInt(arr[12]);
                varArr[5] = Integer.parseInt(arr[13]);
                varArr[6] = Integer.parseInt(arr[14]);
                varArr[7] = Integer.parseInt(arr[15]);

                processInning(matchID, inning, battingTeam, ballingTeam, over, ball, batsman, baller, varArr);

            }
        } catch (IOException io) {
            System.out.println(" IO Exception Detected");
            return;
        } catch (Exception e) {
            System.out.println(" Exception Detected");
            return;
        }

    }

    public Map<Integer, Match> getIdMatchMap() {
        return idMatchMap;
    }

    private void processInning(int matchID, int inning, String battingTeam, String ballingTeam,
                               int over, int ball, String batsman, String baller, int[] runs) {

        Match match = idMatchMap.get(matchID);

        if (match.doesNotContainInning(inning)) addNewInning(match, inning, battingTeam, ballingTeam);

        Inning presentInning = match.getInning(inning);

        processOver(presentInning, over, ball, batsman, baller, runs);

    }

    private void addNewInning(Match match, int inning, String battingTeam, String ballingTeam) {
        Inning inning1 = new Inning(inning, battingTeam, ballingTeam);
        match.addInning(inning1);
    }

    private void processOver(Inning inning, int over, int ball, String batsman, String baller, int[] runs) {


        if (inning.doesNotContainOver(over)) addNewOver(over, inning);

        Over myOver = inning.getOver(over);

        processBall(myOver, ball, batsman, baller, runs);
    }

    private void addNewOver(int over, Inning inning) {
        Over over1 = new Over(over);
        inning.addOver(over1);
    }

    private void processBall(Over over, int ball, String batsman, String baller, int[] runs) {
        assert (runs.length == 9);
        Map<Integer, Integer> runTypeMap = new HashMap<>();

        List<Integer> list = RunType.getRunTypes();

        for (Integer runType : list) {
            if (runs[runType] != 0) {
                runTypeMap.put(runType, runs[runType]);
            }
        }

        Ball myBall = new Ball(ball, batsman, baller, runTypeMap);

        over.addBall(myBall);

    }
}

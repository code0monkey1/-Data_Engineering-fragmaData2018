package controller;

import helperobjects.BallerForSort;
import helperobjects.TeamForSort;
import model.Inning;
import model.Match;
import model.RunType;
import model.Team;
import model.filterCriteria.*;

import java.util.*;

public class Statistics {


    Map<Integer, Match> idMatchMap;
    Map<String, Team> nameTeamMap;


    public Statistics(Map<Integer, Match> idMatchMap, Map<String, Team> nameTeamMap) {
        this.idMatchMap = idMatchMap;
        this.nameTeamMap = nameTeamMap;
    }

    public void printTopNTeamsInYear(int top, int year) {
//        System.out.println("Enters here : ");
        //first screen all valid entries
        // i.e the ones that entereed in that year
        // plus the ones that are a validMatch
        // and where the fielding was first

        Map<String, Integer> teamScoreMap = new HashMap<>();

        for (int id : idMatchMap.keySet()) {

            Match match = idMatchMap.get(id);

            And allConditionsHoldTrue = new And(new ContainsYear(match, year),
                    new IsValidMatch(match), new FieldFirst(match));

            if (allConditionsHoldTrue.isValid()) {
                String team = match.getTossWinner();
                teamScoreMap.put(team, 0);
            }
        }
        //  System.out.println("Debugging : gets to the middle");
        Map<String, Integer> validTeamScoreMap = getValidTeamsScoreMap(teamScoreMap, year);
        PriorityQueue<TeamForSort> sortedTeams = getProperTreeStructure(validTeamScoreMap);

        //  System.out.println("Debug : printingInitialMap");
        //  System.out.println(validTeamScoreMap);

        //System.out.println("Debug : printingMapInCorrectForm");
        // System.out.println(sortedTeams);

        System.out.println("Top " + (sortedTeams.size() < top ? sortedTeams.size() : top) + " teams in the year " + year + " are :\n");
        while (!sortedTeams.isEmpty()) {

            if (top == 0) return;

            System.out.println(sortedTeams.poll().getName());

            top--;
        }
        System.out.println("\n");
    }

    private Map<String, Integer> getValidTeamsScoreMap(Map<String, Integer> teamScoreMap, int year) {

        for (int id : idMatchMap.keySet()) {

            Match match = idMatchMap.get(id);
            ContainsYear containsYear = new ContainsYear(match, year);

            if (containsYear.isValid()) {

                String team = match.getWinningTeam();
                //ensure that it's a valid team
                if (teamScoreMap.containsKey(team)) {
                    int initalScore = teamScoreMap.get(team);
                    // increment value
                    teamScoreMap.put(team, initalScore + 1);
                }
            }

        }

        return teamScoreMap;
    }

    private PriorityQueue<TeamForSort> getProperTreeStructure(Map<String, Integer> validTeamsScoreMap) {
        PriorityQueue<TeamForSort> sortedQueue = new PriorityQueue<>();

        for (String teamName : validTeamsScoreMap.keySet()) {
            sortedQueue.add(new TeamForSort(teamName, validTeamsScoreMap.get(teamName)));
        }

        return sortedQueue;
    }

    public void printAllTeamScoresInAllYears() {
        //take a single team , print it's scores for all years
        // we could do this faster , but it will consume a lot more memory ( so here i'm trading off time for memory )//approxO(n)^2 solution

        List<String> teams = getTeamsList();
        List<Integer> years = getYearsList();

        for (String team : teams) {

            for (int year : years) {

                printTeamScoreInYear(team, year);

            }
            System.out.println("\n");
        }

    }

    private void printTeamScoreInYear(String team, int year) {


        int totalScore = 0;
        int fours = 0;
        int sixes = 0;

        for (Match match : getIdMatchMap().values()) {

            And allConditionTrue = new And(new ContainsYear(match, year), new ContainsTeam(match, team));

            if (allConditionTrue.isValid()) {

                if (match.getInning(1).getBallingTeam().equals(team)) { // 1st inning would be played for sure ,else match won't exist
                    totalScore += match.getInning(1).getRunsOfType(RunType.TOTAL_RUNS);
                    sixes += match.getInning(1).getTotalSixes();
                    fours += match.getInning(1).getTotalSixes();
                } else {
                    if (match.inningExists(2)) {   // the 2nd inning may not have been played

                        totalScore += match.getInning(2).getRunsOfType(RunType.TOTAL_RUNS);
                        sixes += match.getInning(2).getTotalSixes();
                        fours += match.getInning(2).getTotalSixes();
                    }
                }
            }
        }

        System.out.println(year + " " + team + "         " + fours + "        " + sixes + "       " + totalScore);

        // build a valinKeymap with team names as key and an array[3] as value

        //  putValidTeamNameKeys(teamScoreMap, year);
        // traverse through the matches and see if either team has a name as key of ValidKeymap

        //   traverseThroughMatchesAndAddScore(teamScoreMap);
        // add to the of playerNameKey value totalRuns/Sixes/fours in the value array of the inning they batted
        // finally print the map
    }


//    private void putValidTeamNameKeys(Map<String, int[]> teamScoreMap, int year) {
//
//        for (Match match : getIdMatchMap().values()) {
//            ContainsYear containsYear = new ContainsYear(match, year);
//            if (containsYear.isValid()) {
//                teamScoreMap.put(match.getFirstTeam(), new int[3]);
//                teamScoreMap.put(match.getSecondTeam(), new int[3]);
//            }
//        }
//
//    }
//
//    private void traverseThroughMatchesAndAddScore(Map<String, int[]> teamScoreMap) {
//
//        for (Match match : getIdMatchMap().values()) {
//            String battingFirstTeam = match.getBattingFirstTeam();
//            String ballingFirstTeam = match.getBallingFirstTeam();
//
//            if (teamScoreMap.containsKey(battingFirstTeam)) {
//                int arr[] = teamScoreMap.get(battingFirstTeam);
//                addRunsEntry(match, arr, 1);
//
//            } else if (teamScoreMap.containsKey(match.getBallingFirstTeam())) {
//
//            }
//        }
//    }
//
//    private void addRunsEntry(Match match, int[] arr, int inning) {
//        Inning myInning = match.getInning(inning);
//        //fours count (0)
//        // sixes count (1)
//        // total count (2)
//        arr[0] += myInning.getTotalFours();
//        arr[1] += myInning.getTotalSixes();
//        arr[2] += myInning.getTotalRuns();
//    }


    public void printTopNballersInAllMatchYears(int top) {

        // **MAJOR ASSUMPTION  : all player names are unique across all teams

        // first get the years list
        List<Integer> years = getYearsList();
        List<String> ballers = getBallersList();
        // for each baller do the following :
        for (int year : years) {

            Map<String, Integer> ballerRunsGivenMap = new HashMap<>();
            Map<String, Integer> ballerBallsBowledMap = new HashMap<>();
            PriorityQueue<BallerForSort> economyBaller = new PriorityQueue<>();

            for (String baller : ballers) {

                for (Match match : getIdMatchMap().values()) {
                    if (match.getYear() == year && match.hasBaller(baller)) {

                        if (!ballerRunsGivenMap.containsKey(baller)) ballerRunsGivenMap.put(baller, 0);
                        int initialScore = ballerRunsGivenMap.get(baller);
                        int matchTotalScoreByBaller = match.getTotalRunsByBallerForRunType(baller, RunType.TOTAL_RUNS);
                        int matchLegByeScoreByBaller = match.getTotalRunsByBallerForRunType(baller, RunType.LEGBYE_RUNS);
                        int matchByeScoreByBaller = match.getTotalRunsByBallerForRunType(baller, RunType.BYE_RUNS);
                        ballerRunsGivenMap.put(baller, initialScore + (matchTotalScoreByBaller - (matchLegByeScoreByBaller + matchByeScoreByBaller)));

                        if (!ballerBallsBowledMap.containsKey(baller)) ballerBallsBowledMap.put(baller, 0);
                        int previousNumberOfBalls = ballerBallsBowledMap.get(baller);
                        int numberOfBallsBowledInMatch = match.getNumberOfBallsBowledByBowler(baller);
                        ballerBallsBowledMap.put(baller, previousNumberOfBalls + numberOfBallsBowledInMatch);
                    }
                }


            }
            for (String name : ballerRunsGivenMap.keySet()) {

                double ballerRunsGiven = ballerRunsGivenMap.get(name);
                double ballerOversBowled = ballerBallsBowledMap.get(name) / 7.0;
                assert (ballerOversBowled > 0);

                int economyScore = (int) (ballerRunsGiven / ballerOversBowled);

                economyBaller.add(new BallerForSort(name, economyScore));
            }
            int limit = (top < economyBaller.size() ? top : economyBaller.size());


            System.out.println("YEAR    PLAYER    ECONOMY");


            for (int i = 0; i < limit; i++) {
                BallerForSort currentBaller = economyBaller.poll();
                System.out.println(year + " " + currentBaller.getName() + " " + currentBaller.getScore());
            }
            System.out.println("\n");
        }
        // go through all matches and see if the year is correct (else continue)
        // if correct then get the runType given by baller

    }


    private List<String> getBallersOfTeam(Team team) {
        List<String> ballers = new ArrayList<>();

        return ballers;

    }

    private List<String> getTeamsList() {
        List<String> teams = new ArrayList<>(getNameTeamMap().keySet());
        return teams;
    }

    public List<String> getBallersList() {
        Set<String> uniqueBallers = new HashSet<>();

        for (Match match : getIdMatchMap().values()) {
            uniqueBallers.addAll(match.getBowlersList());
        }
        List<String> ballers = new ArrayList<>(uniqueBallers);
        return ballers;
    }


    private int getBallerOversInYear(int year, String team, String baller) {
        int overs = 0;


        return overs;

    }

    private double getBallerEconomyForYear(int year, String baller) {
        double economyRate = 0;


        return economyRate;

    }

    public List<Integer> getYearsList() {
        //latest year to least year
        Set<Integer> yearSet = new TreeSet<>(Collections.reverseOrder());
        for (Match match : idMatchMap.values()) {
            yearSet.add(match.getYear());
        }
        List<Integer> years = new ArrayList<>(yearSet);

        return years;
    }


    private List<String> getTeamsWonTossFeilded() {
        List<String> teams = new ArrayList<>();


        return teams;
    }

    public Map<Integer, Match> getIdMatchMap() {
        return idMatchMap;
    }

    public Map<String, Team> getNameTeamMap() {
        return nameTeamMap;
    }

}

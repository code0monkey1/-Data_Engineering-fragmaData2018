package controller;


import model.Inning;
import model.Match;
import model.Over;
import model.Team;
import org.junit.Before;
import org.junit.Test;
import utilities.PopulateDeliveries;
import utilities.PopulateMatches;


import java.util.*;

import static org.junit.Assert.*;

public class StatisticsTest {
    private Statistics statistics;

    @Before
    public void setUp() throws Exception {
        PopulateMatches populateMatches = new PopulateMatches("matches.csv");

        Map<Integer, Match> mapper = populateMatches.getIdMatchMap();
//        System.out.println(mapper);

//        System.out.println("\n After");
        PopulateDeliveries populateDeliveries = new PopulateDeliveries("deliveries.csv", populateMatches.getIdMatchMap());
//        System.out.println(mapper);

        this.statistics = new Statistics(populateMatches.getIdMatchMap(), populateMatches.getNameTeamMap());

    }

    @Test
    public void printTopNTeamsInYear() {

        statistics.printTopNTeamsInYear(4, 2016);

    }

    @Test
    public void printTeamScoreInYear() {
        assertFalse(true);
    }

    @Test
    public void printNBallersInYear() {
        assertFalse(true);
    }

    @Test
    public void getIdMatchMap() {
        assertFalse(true);
    }

    @Test
    public void getNameTeamMap() {
        assertFalse(true);
    }

    @Test
    public void workingOfATreeMap() {
        Map<String, Integer> nameScore = new HashMap<>();
        nameScore.put("chiranjeev", 1);
        nameScore.put("chiranjeev", nameScore.get("chiranjeev") + 1);
        nameScore.put("bhasker", -2);

        Map<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());

        for (String name : nameScore.keySet()) {
            int score = nameScore.get(name);
            treeMap.put(score, name);
        }
        int i = 1;
        assertEquals(2, treeMap.size());
        for (Integer value : treeMap.keySet()) {
            String name = treeMap.get(value);

            if (i == 1) {
                assertEquals("chiranjeev", name);
            } else {
                assertEquals("bhasker", name);
            }
            i++;
        }
    }

    @Test
    public void allTeamsAreContainedInIdMapAndTeamMap() {
        Set<String> uniqueTeamNames = new HashSet<>();
        for (int id : statistics.getIdMatchMap().keySet()) {
            Match match = statistics.getIdMatchMap().get(id);
            uniqueTeamNames.add(match.getFirstTeam());
            uniqueTeamNames.add(match.getSecondTeam());
        }
        Set<String> namesOfTeam = statistics.getNameTeamMap().keySet();
        assertEquals(uniqueTeamNames, namesOfTeam);
    }

    @Test
    public void allYearsContainedInProperOrderInGetYearListFunction() {
        List<Integer> retrievedYearList = statistics.getYearsList();
        List<Integer> yearsList = new ArrayList<>();
        int startYear = 2008;
        for (int i = 0; i <= 9; i++) {
            yearsList.add(startYear + i);
        }
        assertEquals(yearsList, retrievedYearList);

    }

    @Test
    public void allOversConsistOfaSingleBowler() {
        for (Match match : statistics.getIdMatchMap().values()) {

            for (Inning inning : match.getInningsMap().values()) {

                for (Over over : inning.getNumberOversMap().values()) {
                    System.out.println(over.getBowlersList());
                    assertEquals(true, over.getBowlersList().size()>=2);
                }
            }
        }
    }

}
package utilities;

import model.Match;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class PopulateMatchesTest {
    private PopulateMatches populateMatches;

    @Before
    public void setUp() throws Exception {
        populateMatches = new PopulateMatches("C:\\Users\\Chiranjeev\\Documents\\IdeaProjects\\TMCProjects\\mooc-2013-OOProgrammingWithJava-PART2\\fragmaData\\tests\\matchesTest.csv");
    }

    @Test
    public void totalNumberOfUniqueMatches() {
        assertEquals(3, populateMatches.getIdMatchMap().size());
    }

    @Test
    public void totalNumberOfUniqueTeams() {
        assertEquals(4, populateMatches.getNameTeamMap().size());
    }

    @Test
    public void InningsOfMatchesEmptyAtStart() {
        Map<Integer, Match> map = populateMatches.getIdMatchMap();

        for (int num : map.keySet()) {
            Match match = map.get(num);
            boolean isEmpty = match.getInningsMap().isEmpty();
            assertEquals(true, isEmpty);
        }
    }

    @Test
    public void allTeamsHaveUniquePlayerNames() {

    }


}
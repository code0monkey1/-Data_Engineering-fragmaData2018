package utilities;

import model.Inning;
import model.Match;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PopulateDeliveriesTest {
    private PopulateDeliveries populateDeliveries;
    private PopulateMatches populateMatches;

    @Before
    public void setUp() throws Exception {

        populateMatches = new PopulateMatches("C:\\Users\\Chiranjeev\\Documents\\IdeaProjects\\TMCProjects\\mooc-2013-OOProgrammingWithJava-PART2\\fragmaData\\tests\\matchesTest.csv");

        populateDeliveries = new PopulateDeliveries("C:\\Users\\Chiranjeev\\Documents\\IdeaProjects\\TMCProjects\\mooc-2013-OOProgrammingWithJava-PART2\\fragmaData\\tests\\deliveriesTest.csv", populateMatches.getIdMatchMap());
    }

    @Test
    public void checkBattingTeamInInning() {
        Match match = populateDeliveries.getIdMatchMap().get(1);
        String battingTeam = match.getInning(1).getBattingTeam();
        assertEquals("Sunrisers Hyderabad", battingTeam);
    }

    @Test
    public void checkBallingTeamInInning() {
        Match match = populateDeliveries.getIdMatchMap().get(1);
        String ballingTeam = match.getInning(1).getBallingTeam();
        assertEquals("Royal Challengers Bangalore", ballingTeam);
    }

    @Test
    public void checkEntrySizeOfMatches() {
        Match match = populateDeliveries.getIdMatchMap().get(1);
        String ballingTeam = match.getInning(1).getBallingTeam();
        assertEquals("Royal Challengers Bangalore", ballingTeam);
    }
    @Test
    public void allMatchIDsAreUnique() {
        Match match = populateDeliveries.getIdMatchMap().get(1);
        String ballingTeam = match.getInning(1).getBallingTeam();
        assertEquals("Royal Challengers Bangalore", ballingTeam);
    }


}
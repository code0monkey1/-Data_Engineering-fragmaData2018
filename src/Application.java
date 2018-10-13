import controller.Statistics;
import model.Inning;
import model.Match;
import model.Over;
import utilities.PopulateDeliveries;
import utilities.PopulateMatches;
import view.UI;

import java.util.Map;

public class Application {

    public static void main(String[] args) {


        PopulateMatches populateMatches = new PopulateMatches("matches.csv");

//        Map<Integer, Match> mapper = populateMatches.getIdMatchMap();
//        System.out.println(mapper);

//        System.out.println("\n After");
        PopulateDeliveries populateDeliveries = new PopulateDeliveries("deliveries.csv", populateMatches.getIdMatchMap());
//        System.out.println(mapper);

        Statistics statistics = new Statistics(populateMatches.getIdMatchMap(), populateMatches.getNameTeamMap());
//        System.out.println(statistics.getNameTeamMap().keySet().size());
//        System.out.println(statistics.getBallersList());
        //  System.out.println(populateMatches.getIdMatchMap().size());
//        allOversConsistOfaSingleBowler(statistics);
          UI ui = new UI(statistics);

           ui.run();
//        System.out.println("Debugging Matches");
//        System.out.println(populateMatches.getIdMatchMap());
//
//        System.out.println("Debugging Teams");
//        System.out.println(populateMatches.getNameTeamMap());
    }

//    public static void allOversConsistOfaSingleBowler(Statistics statistics) {
//        for (Match match : statistics.getIdMatchMap().values()) {
//
//            for (Inning inning : match.getInningsMap().values()) {
//
//                for (Over over : inning.getNumberOversMap().values()) {
////                    System.out.println(over.getBowlersList());
//                    if (over.getBowlersList().size() > 1) {
//                        System.out.println(over.getBowlersList().size());
//                        System.out.println(over.getBowlersList());
//                    }
//                }
//            }
//        }
//    }

}

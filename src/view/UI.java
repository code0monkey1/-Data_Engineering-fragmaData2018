package view;

import controller.Statistics;

import java.util.Scanner;

public class UI {

    private Scanner scanner;
    private Statistics statistics;

    public UI(Statistics statistics) {
        this.statistics = statistics;
        this.scanner = new Scanner(System.in);
    }

    public void run() {

        while (true) {
            System.out.println("Choose the operation you'd like to perform : \n " +
                    "_____________________________________________" +
                    "\n" +
                    "To exit :\n Enter '0' \n" +
                    "To get Top N ( variable specified by user at runtime ) teams which elected to field first after winning toss in the year : year1 (variable specified by user ) and : year 2 ( variable specified by user at runtime ) :\n" +
                    " Enter : 1 \n" +
                    "To List total number of fours, sixes, total score with respect to team and year :\n" +
                    " Enter : 2  \n" +
                    "To List Top N ( variable specified by user at runtime ) best economy rate bowler with respect to year who bowled at least num (variable specified by user at runtime  ) overs [ (excluding) LEGBYE_RUNS and BYE_RUNS ] : \n Enter : 3  \n" +
                    "To List the team name which has Highest Net Run Rate with respect to year:\n" +
                    " Enter : 4 \n");

            String entry = scanner.nextLine();

            if (entry.equals("0")) {
                System.out.println("Program Ends");
                return;
            } else if (entry.equals("1")) {
                System.out.println("\nEnter the number of top teams you want to view");
                int top = Integer.parseInt(scanner.nextLine());

                System.out.println("\nEnter the first year ");
                int year1 = Integer.parseInt(scanner.nextLine());

                //  System.out.println("Debugging :" + top + " " + year1);
                statistics.printTopNTeamsInYear(top, year1);
                System.out.println("\nEnter the second year ");

                int year2 = Integer.parseInt(scanner.nextLine());
                statistics.printTopNTeamsInYear(top, year2);
                System.out.println("\n");

            } else if (entry.equals("2")) {
                System.out.println("Printing scores of  all teams in all years of matches \n");
                System.out.println("Year  TeamName    Fours_Count    Sixes_Count    Total_Score");
                statistics.printAllTeamScoresInAllYears();

            } else if (entry.equals("3")) {
                System.out.println("Specify a number metioing the top number of ballers you want to see in each year ");
                int top = Integer.parseInt(scanner.nextLine());

                statistics.printTopNballersInAllMatchYears(top);
                System.out.println("\n");

            } else if (entry.equals("4")) {

                System.out.println("RAN OUT OF TIME -- WILL IMPLEMENT LATER , SORRY!!  :( ");
            }
        }

    }
}

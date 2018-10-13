package model;

import java.util.*;

public class Inning {

    private Map<Integer, Over> numberOversMap;
    private int inningNumber;
    private String battingTeam;
    private String ballingTeam;

    public Inning(int number, String battingTeam, String ballingTeam) {
        this.ballingTeam = ballingTeam;
        this.battingTeam = battingTeam;
        this.inningNumber = number;
        numberOversMap = new HashMap<>();
    }

    public Map<Integer, Over> getNumberOversMap() {
        return numberOversMap;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public String getBallingTeam() {
        return ballingTeam;
    }


    public boolean doesNotContainOver(int over) {
        return !numberOversMap.containsKey(over);
    }


    public Over getOver(int over) {
        return numberOversMap.get(over);
    }

    @Override
    public String toString() {
        return "Inning{" +
                "numberOversMap=" + numberOversMap +
                ", inning number=" + inningNumber +
                ", battingTeam='" + battingTeam + '\'' +
                ", ballingTeam='" + ballingTeam + '\'' +
                '}';
    }

    public void addOver(Over over) {

        numberOversMap.put(over.getNumber(), over);
    }

    public boolean hasBaller(String baller) {

        for (Over over : numberOversMap.values()) {
            if (over.hasBaller(baller)) return true;
        }
        return false;
    }

    public List<String> getBowlersList() {
        Set<String> uniqueBallers = new HashSet<>();

        for (Over over : numberOversMap.values()) {
            uniqueBallers.addAll(over.getBowlersList());
        }
        List<String> ballers = new ArrayList<>(uniqueBallers);
        return ballers;
    }


    public int getRunsOfType(int type) {
        int runs = 0;
        for (Over over : numberOversMap.values()) {

            runs += over.getRunsOfType(type);
        }
        return runs;
    }


    public int getTotalRunsByBallerForRunType(String baller, int type) {
        if (!hasBaller(baller)) return 0;
        int totalRunsOfBallerOfRunType = 0;

        for (Over over : getNumberOversMap().values()) {

            totalRunsOfBallerOfRunType += over.getTotalRunsByBallerForRunType(baller, type);
        }

        return totalRunsOfBallerOfRunType;
    }

    public int getNumberOfBallsBowledByBowler(String baller) {
        if (!hasBaller(baller)) return 0;
        int totalNumberOfBallsBowled = 0;
        for (Over over : numberOversMap.values()) {
            if (over.hasBaller(baller)) {
                totalNumberOfBallsBowled += over.getTotalNumberOfBallsBowledByBowler(baller);
            }
        }
        return totalNumberOfBallsBowled;
    }


    public int getTotalFours() {
        //assumption , if the BatsmanRuns is 4, then it is supposed that it's a 4 by a stroke , not by running between wickets
        int fours = 0;
        for (Over over : numberOversMap.values()) {

            fours += over.getTotalFours();
        }
        return fours;
    }


    public int getTotalSixes() {
        //assumption , if the BatsmanRuns is 6, then it is supposed that it's a 6 by a stroke , not by running between wickets
        int sixes = 0;
        for (Over over : numberOversMap.values()) {

            sixes += over.getTotalSixes();
        }
        return sixes;
    }

    public int getNumber() {
        return inningNumber;
    }


}

package model;

import java.util.*;

public class Over {

    private Map<Integer, Ball> numberBallMap;
    private int overNumber;

    public Over(int number) {
        this.overNumber = number;
        numberBallMap = new HashMap<>();
    }

    public void addBall(Ball ball) {

        numberBallMap.put(ball.getNumber(), ball);
    }

    public boolean hasBaller(String baller) {

        return getBowlersList().contains(baller);
    }

    public int getRunsOfType(int runType) {
        int total = 0;

        for (Ball ball : numberBallMap.values()) {

            total += ball.getRunsOfType(runType);
        }
        return total;
    }

    public List<String> getBatsMenList() {
        List<String> batsmanList = new ArrayList<>();

        for (int ballNumber : numberBallMap.keySet()) {
            Ball ball = numberBallMap.get(ballNumber);
            String batsman = ball.getBatsmanName();

            if (!batsmanList.contains(batsman)) {
                batsmanList.add(batsman);
            }
        }
        return batsmanList;
    }


    public List<String> getBowlersList() {

        Set<String> ballers = new HashSet<>();
        for (Ball ball : numberBallMap.values()) {
            ballers.add(ball.getBallerName());
        }

        List<String> ballerList = new ArrayList<>(ballers);
        return ballerList;
    }

    public int getTotalNumberOfBallsBowledByBowler(String baller) {
        if (!hasBaller(baller)) return 0;

        int totalBalls = 0;
        for (Ball ball : numberBallMap.values()) {
            if (ball.getBallerName().equals(baller)) {
                totalBalls++;
            }
        }
        return totalBalls;
    }

    public int getTotalRunsByBallerForRunType(String baller, int type) {
        if (!hasBaller(baller)) return 0;

        int totalRunsOfRunType = 0;
        for (Ball ball : numberBallMap.values()) {
            totalRunsOfRunType += ball.getRunsOfType(type);
        }

        return totalRunsOfRunType;
    }


    public int getRunsOfBatsman(String batsman) {

        int runs = 0;
//        for (int ballNumber : numberBallMap.keySet()) {
//            Ball ball = numberBallMap.get(ballNumber);
//            if (ball.getBatsmanName().equals(batsman)) {
//                runs += ball.getRunsOfType();
//            }
//
        return runs;

    }

//    public int getRunsOfBowler(String baller) {
//        int runs = 0;
//        for (int ballNumber : numberBallMap.keySet()) {
//            Ball ball = numberBallMap.get(ballNumber);
//            if (ball.getBallerName().equals(baller)) {
//                runs += ball.getTotalRuns();
//            }
//        }
//        return runs;
//    }

    public int getTotalSixes() {
        int totalSixes = 0;
        for (Ball ball : numberBallMap.values()) {
            if (ball.getRunsOfType(RunType.BATSMAN_RUNS) == 6) totalSixes++;
        }
        return totalSixes;
    }

    public int getTotalFours() {
        int totalFours = 0;
        for (Ball ball : numberBallMap.values()) {
            if (ball.getRunsOfType(RunType.BATSMAN_RUNS) == 4) totalFours++;
        }
        return totalFours;
    }


    @Override
    public String toString() {
        return "Over{" +
                "numberBallMap=" + numberBallMap +
                ", over number=" + overNumber +
                '}';
    }

    public int getNumber() {
        return overNumber;
    }
}

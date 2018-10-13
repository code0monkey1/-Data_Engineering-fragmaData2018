package model;


import java.util.HashMap;
import java.util.Map;

public class Ball {

    private Map<Integer, Integer> runTypeScoreMap;
    private String batsman;
    private String baller;
    private int ballNumber;


    public Ball(int number, String batsman, String baller, Map<Integer, Integer> runTypeScoreMap) {
        this.runTypeScoreMap = new HashMap<>();
        this.ballNumber = number;
        this.baller = baller;
        this.batsman = batsman;
        this.runTypeScoreMap = runTypeScoreMap;
    }


    public String getBatsmanName() {
        return batsman;
    }

    public String getBallerName() {
        return baller;
    }

    public int getNumber() {
        return ballNumber;
    }

    public int getRunsOfType(int type) {
        if (!runTypeScoreMap.containsKey(type)) return 0;
        return runTypeScoreMap.get(type);
    }


    @Override
    public String toString() {
        return "Ball{" +
                "runTypeScoreMap=" + runTypeScoreMap +
                ", batsman='" + batsman + '\'' +
                ", baller='" + baller + '\'' +
                ", ball number=" + ballNumber +
                '}';
    }
}

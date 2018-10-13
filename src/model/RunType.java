package model;

import java.util.Arrays;
import java.util.List;

public class RunType {
    public static final int WIDE_RUNS = 0;
    public static final int BYE_RUNS = 1;
    public static final int LEGBYE_RUNS = 2;
    public static final int NOBALL_RUNS = 3;
    public static final int PENALTY_RUNS = 4;
    public static final int BATSMAN_RUNS = 5;
    public static final int EXTRA_RUNS = 6;
    public static final int TOTAL_RUNS = 7;


    public static List<Integer> getRunTypes() {

        List list = Arrays.asList(WIDE_RUNS, BYE_RUNS, LEGBYE_RUNS, NOBALL_RUNS, PENALTY_RUNS, BATSMAN_RUNS, EXTRA_RUNS, TOTAL_RUNS);
        return list;
    }
}

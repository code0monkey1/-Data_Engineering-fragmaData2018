package model;


import java.util.*;

public class Match {
    private int year;
    private String winningTeam;
    private int tossDecision;
    private String tossWinner;
    private int resultType;
    private String firstTeam;
    private String secondTeam;
    private int matchID;
    private String date;
    private String city;
    private Map<Integer, Inning> numberInningMap;


    public Match(int matchID, int season, String city, String date, String team1,
                 String team2, String tossWinner, int tossDecision,
                 int resultType, String winner) {

        this.matchID = matchID;
        this.year = season;
        this.date = date;

        this.firstTeam = team1;
        this.secondTeam = team2;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.winningTeam = winner;
        this.resultType = resultType;
        this.city = city;
        this.numberInningMap = new HashMap<>();

    }

    public boolean inningExists(int inning) {
        return numberInningMap.containsKey(inning);
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public Map<Integer, Inning> getInningsMap() {
        return numberInningMap;
    }

    public Inning getInning(int inning) {
        return numberInningMap.get(inning);
    }
//    public void dateAssign(String date) throws DateFormatException {
//        String[] dateArray = date.split(".");
//        if (dateArray.length != 3) throw new DateFormatException();
//
//        try {
//            int day = Integer.parseInt(dateArray[0]);
//            int month = Integer.parseInt(dateArray[1]);
//            int year = Integer.parseInt(dateArray[2]);
//
//
//            if (!isDateValid(year, month, day)) throw new Exception();
//
//            this.date[0] = day;
//            this.date[1] = month;
//            this.date[2] = year;
//
//        } catch (Exception num) {
//            throw new DateFormatException();
//        }

//
//    }
//
//    private boolean isDateValid(int year, int month, int day) {
//
//        boolean valid = true;
//        Calendar calendar = new GregorianCalendar(year, month, day);
//        if (year != calendar.get(Calendar.YEAR)) {
//            valid = false;
//        } else if (month != calendar.get(Calendar.MONTH)) {
//            valid = false;
//        } else if (day != calendar.get(Calendar.DAY_OF_MONTH)) {
//            valid = false;
//        }
//        return valid;
//    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public int getTossDecision() {
        return tossDecision;
    }

    public int getResultType() {
        return resultType;
    }

    public int getYear() {
        return year;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public int getMatchID() {
        return matchID;
    }

    public void addInning(Inning inning) {
        numberInningMap.put(inning.getNumber(), inning);
    }

    public boolean doesNotContainInning(int inning) {
        return !numberInningMap.containsKey(inning);
    }

    public boolean hasBaller(String baller) {
        for (Inning inning : getInningsMap().values()) {
            if (inning.hasBaller(baller)) return true;
        }
        return false;
    }

    public int getNumberOfBallsBowledByBowler(String baller) {
        if (!hasBaller(baller)) return 0;
        int totalBalls = 0;
        for (Inning inning : getInningsMap().values()) {
            totalBalls += inning.getNumberOfBallsBowledByBowler(baller);
        }

        return totalBalls;
    }

    public List<String> getBowlersList() {
        Set<String> uniqueBallers = new HashSet<>();
        for (Inning inning : getInningsMap().values()) {
            uniqueBallers.addAll(inning.getBowlersList());
        }

        List<String> ballers = new ArrayList<>(uniqueBallers);
        return ballers;
    }

    public int getTotalRunsByBallerForRunType(String baller, int type) {

        if (!hasBaller(baller)) return 0;
        int totalRunsByBallerOfRunType = 0;

        for (Inning inning : getInningsMap().values()) {

            totalRunsByBallerOfRunType += inning.getTotalRunsByBallerForRunType(baller, type);
        }

        return totalRunsByBallerOfRunType;
    }

    public String getBattingFirstTeam() {
        if (this.tossDecision == TossDecision.BAT) {
            return tossWinner.equals(firstTeam) ? firstTeam : secondTeam;
        } else {
            return tossWinner.equals(firstTeam) ? secondTeam : firstTeam;
        }
    }

    public String getBallingFirstTeam() {
        return getBattingFirstTeam().equals(firstTeam) ? secondTeam : firstTeam;
    }

    @Override
    public String toString() {
        return "Match{" +
                "year=" + year +
                ", winningTeam='" + winningTeam + '\'' +
                ", tossDecision=" + tossDecision +
                ", tossWinner='" + tossWinner + '\'' +
                ", resultType=" + resultType +
                ", firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", matchID=" + matchID +
                ", date=" + date +
                ", city='" + city + '\'' +
                ", numberInningMap=" + numberInningMap +
                '}';
    }
}

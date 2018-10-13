package model;

import java.util.*;

public class Team {

    private String name;
    List<Integer> matchIDs;

    public Team(String name) {
        this.name = name;
        this.matchIDs = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public List<Integer> getMatchIDs() {

        return matchIDs;
    }

    public void addMatchID(int matchID) {
        matchIDs.add(matchID);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return name != null ? name.equals(team.name) : team.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", matchIDs=" + matchIDs +
                '}';
    }
}

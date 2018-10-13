package model.filterCriteria;

import model.Match;

public class ContainsTeam implements Criterion {
    private String team;
    private Match match;


    public ContainsTeam(Match match, String team) {
        this.team = team;
        this.match = match;

    }

    @Override
    public boolean isValid() {
        return match.getFirstTeam().equals(team) || match.getSecondTeam().equals(team);
    }
}

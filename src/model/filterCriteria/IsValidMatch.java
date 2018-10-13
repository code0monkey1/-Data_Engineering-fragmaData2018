package model.filterCriteria;

import model.Match;
import model.MatchResult;

public class IsValidMatch implements Criterion {

    private Match match;

    public IsValidMatch(Match match) {
        this.match = match;
    }

    @Override
    public boolean isValid() {
        return match.getResultType() != MatchResult.NORESULT;
    }
}

package model.filterCriteria;

import model.Match;
import model.TossDecision;

public class FieldFirst implements Criterion {

    private Match match;

    public FieldFirst(Match match) {
        this.match = match;
    }

    @Override
    public boolean isValid() {
        return match.getTossDecision() == TossDecision.FIELD;

    }
}

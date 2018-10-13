package model.filterCriteria;

import model.Match;


public class ContainsYear implements Criterion {

    private int year;
    private Match match;


    public ContainsYear(Match match, int year) {
        this.year = year;
        this.match = match;

    }

    @Override
    public boolean isValid() {
        return match.getYear() == year;
    }


}

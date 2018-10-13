package model.filterCriteria;

import model.Team;

import java.util.ArrayList;
import java.util.List;

public class And implements Criterion {

    private Criterion[] criterionList;

    public And(Criterion... criterionList) {
        this.criterionList = criterionList;
    }


    @Override
    public boolean isValid() {

        for (Criterion criterion : criterionList) {
            if (!criterion.isValid()) return false;
        }

        return true;
    }
}

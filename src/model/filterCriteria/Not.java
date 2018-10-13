package model.filterCriteria;

import java.util.List;

public class Not implements Criterion {

    List<Criterion> criterionList;

    public Not(List<Criterion> criteria) {
        this.criterionList = criteria;
    }

    @Override
    public boolean isValid() {

        for (Criterion criterion : criterionList) {
            if (criterion.isValid()) return false;
        }
        return true;
    }
}

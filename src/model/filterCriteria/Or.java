package model.filterCriteria;

import model.Team;

import java.util.ArrayList;
import java.util.List;

public class Or implements Criterion {

    List<Criterion> criteriaList;

    public Or(ArrayList<Criterion> criteria) {

        criteriaList = new ArrayList<>();
        criteriaList.addAll(criteria);

    }

    @Override
    public boolean isValid() {
        for (Criterion criterion : criteriaList) {
            if (criterion.isValid()) return true;
        }
        return false;
    }
}

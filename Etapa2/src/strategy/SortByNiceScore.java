package strategy;

import objects.Child;

import java.util.Comparator;

public final  class SortByNiceScore implements Comparator<Child> {

    @Override
    public int compare(final Child first, final Child second) {
        if (first.getNiceScore() == second.getNiceScore()) {
            return first.getId() - second.getId();
        }
        return Double.compare(second.getNiceScore(), first.getNiceScore());
    }
}

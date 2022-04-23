package strategy;

import objects.Child;

import java.util.Comparator;

public final class SortByCity implements Comparator<Child> {

    @Override
    public int compare(final Child first, final Child second) {
        if (first.getNiceScoreCity().equals(second.getNiceScoreCity())) {
            if (first.getCity().equals(second.getCity())) {
                return first.getId() - second.getId();
            }
            return first.getCity().getValue().compareTo(second.getCity().getValue());
        }
        return Double.compare(second.getNiceScoreCity(), first.getNiceScoreCity());
    }
}

package strategy;

import objects.Child;

import java.util.Comparator;

public final class SortById implements Comparator<Child> {

    @Override
    public int compare(final Child first, final Child second) {
        return first.getId() - second.getId();
    }
}

package common;

import factory.Present;
import java.util.Comparator;

public final class PresentSorter implements Comparator<Present> {
    private Present res1;
    private Present res2;

    @Override
    public int compare(final Present first, final Present second) {
        return Double.compare(first.getPrice(), second.getPrice());
    }
}

package observer;

import objects.Child;

public interface ChildObserver {
    /**
     * Notifica clasa copil ca este parcurs un nou copil si ca trebuie sa
     * ii adauge niceScore-ul, daca e din acelasi oras
     * @param child
     */
    void update(Child child);
}

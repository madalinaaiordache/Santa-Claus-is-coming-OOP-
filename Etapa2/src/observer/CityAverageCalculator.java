package observer;

import objects.Child;

import java.util.ArrayList;

public final class CityAverageCalculator {
    private ArrayList<Child> children;

    public CityAverageCalculator(final ArrayList<Child> children) {
        this.children = children;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<Child> children) {
        this.children = children;
    }

    /**
     * Este apelata metoda update din clasa fiecarui copil, unde se calculeaza media,
     * folosind SI nota copilului dat ca parametru, daca este cazul
     * @param child
     */
    public void notify(final Child child) {
        for (Child toNotify : this.children) {
            toNotify.update(child);
        }
    }

    /**
     * Apeleaza metoda notify pentru toti copiii din lista
     */
    public void calculateAverages() {
        for (Child child : this.children) {
            notify(child);
        }
    }
}

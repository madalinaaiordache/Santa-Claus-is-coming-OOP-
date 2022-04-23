package objects;

import java.util.ArrayList;

public final class InitialData {
    private ArrayList<Child> children = new ArrayList<>();
    private ArrayList<PresentInput> santaGiftsList = new ArrayList<>();

    public InitialData() {
        this.children = null;
        this.santaGiftsList = null;
    }

    public InitialData(final ArrayList<Child> children,
                       final ArrayList<PresentInput> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;

    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<Child> children) {
        this.children = children;
    }

    public ArrayList<PresentInput> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<PresentInput> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

}

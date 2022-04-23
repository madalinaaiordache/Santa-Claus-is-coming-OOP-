package objects;

import java.util.ArrayList;

public final class AnnualChange {
    private Double newSantaBudget;
    private ArrayList<PresentInput> newGifts = new ArrayList<>();
    private ArrayList<Child> newChildren = new ArrayList<>();
    private ArrayList<ChildUpdate> childrenUpdates = new ArrayList<>();
    private String strategy;

    public AnnualChange() {
        this.newSantaBudget = 0.0;
        this.newChildren = null;
        this.newGifts = null;
        this.childrenUpdates = null;
    }

    public AnnualChange(final Double newSantaBudget,
                            final ArrayList<PresentInput> newGifts,
                            final ArrayList<Child> newChildren,
                            final ArrayList<ChildUpdate> childrenUpdates,
                             final String strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<PresentInput> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<PresentInput> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final ArrayList<Child> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final ArrayList<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}

package objects;

import enums.Category;

import java.util.ArrayList;

public final class ChildUpdate {
    private int id;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    public ChildUpdate() {
        this.id = 0;
        this.niceScore = 0.0;
        this.giftsPreferences = null;
    }

    public ChildUpdate(final int id, final Double niceScore,
                       final ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}

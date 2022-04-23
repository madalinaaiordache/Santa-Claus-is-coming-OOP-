package objects;

import enums.Category;
import enums.Cities;
import factory.Present;

import java.util.ArrayList;

public final class ChildOutput {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private ArrayList<Category> giftsPreferences;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<PresentOutput> receivedGifts;


    public ChildOutput(final int id, final String lastName,
                final String firstName, final  Cities city, final int age,
                final ArrayList<Category> giftsPreferences,
                final Double averageScore, final ArrayList<Double> niceScoreHistory,
                final Double assignedBudget, final ArrayList<Present> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.assignedBudget = assignedBudget;
        this.niceScoreHistory = niceScoreHistory;
        this.receivedGifts = new ArrayList<>();
        for (Present pres : receivedGifts) {
            this.receivedGifts.add(new PresentOutput(pres.getProductName(),
                    pres.getPrice(), pres.getCategory()));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreference) {
        this.giftsPreferences = giftsPreference;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<PresentOutput> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<PresentOutput> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }
}

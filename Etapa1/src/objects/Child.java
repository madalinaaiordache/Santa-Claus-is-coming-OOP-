package objects;

import enums.AgeCategory;
import enums.Category;
import enums.Cities;
import factory.Present;

import java.util.ArrayList;

import static common.Constants.BABY_LIMIT;
import static common.Constants.KID_LIMIT;
import static common.Constants.KID_SCORE;
import static common.Constants.TEEN_LIMIT;

public final class Child {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private ArrayList<Double> niceScoreList;
    private ArrayList<Category> giftsPreferences;
    private AgeCategory ageCategory;
    private Double santaBudget;
    private ArrayList<Present> presentsReceived;
    private ArrayList<Category> oldCategories;

    public Child() {
        this.id = 0;
        this.lastName = null;
        this.firstName = null;
        this.age = 0;
        this.city = null;
        this.niceScore = null;
        this.giftsPreferences = new ArrayList<>();
        this.santaBudget = 0.0;
        this.presentsReceived = new ArrayList<>();
        this.niceScoreList = new ArrayList<>();
        this.oldCategories = new ArrayList<>();
    }

    public Child(final int id, final String lastName, final String firstName,
                    final int age, final Cities city,
                        final Double niceScore,
                 final ArrayList<Category> giftsPreferences) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.niceScoreList = new ArrayList<>();
        this.niceScoreList.add(niceScore);
        this.oldCategories = new ArrayList<>(giftsPreferences);
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ArrayList<Double> getNiceScoreList() {
        return niceScoreList;
    }

    public void setNiceScoreList(final ArrayList<Double> niceScoreList) {
        this.niceScoreList = niceScoreList;
    }

    /**
     * Adauga un cadou in lista de cadouri primite
     * @param present
     */
    public void addGift(final Present present) {
        this.presentsReceived.add(present);
    }

    /**
     * Functie de realocare
     */
    public void newRoundChild() {
        this.niceScoreList = new ArrayList<>(this.niceScoreList);
        this.giftsPreferences = new ArrayList<>(this.giftsPreferences);
        this.presentsReceived = new ArrayList<>(this.presentsReceived);
        this.oldCategories = new ArrayList<>(this.oldCategories);
    }

    /**
     * Functie pentru adaugarea unui nou scor in lista
     * @param score = scorul adaugat
     */
    public void addNiceScore(final double score) {
        this.niceScoreList.add(score);
    }

    /**
     * Functie pentru calculul scorului la care a ajuns
     */
    public void calculateNiceScore() {
        if (this.ageCategory.equals(AgeCategory.BABY)) {
            this.niceScore = KID_SCORE;
        } else if (this.ageCategory.equals(AgeCategory.KID)) {
            int sum = 0;
            for (Double score : this.niceScoreList) {
                sum += score;
            }
            this.niceScore = (double) sum / this.niceScoreList.size();
        } else if (this.ageCategory.equals(AgeCategory.TEEN)) {
            int sumUp = 0, sumDown = 0;
            for (int i = 0; i < this.niceScoreList.size(); i++) {
                sumUp += (i + 1) * this.niceScoreList.get(i);
                sumDown += (i + 1);
            }
            if (sumDown != 0)  {
                this.niceScore = (double) sumUp / sumDown;
            }
        }
    }

    /**
     * Functie pentru calcularea bugetului mosului pt copil
     */
    public void calculateSantaBudget(final double budgetUnit) {
        this.santaBudget = this.niceScore * budgetUnit;
    }

    public void setAgeCategory(final AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    /**
     * Adauga o categorie in lista de preferinte
     * @param preferences
     */
    public void addGiftPreference(final ArrayList<Category> preferences) {
        for (int it = preferences.size() - 1; it >= 0; it--) {
            Category category = preferences.get(it);
            if (this.getGiftsPreferences().contains(category)) {
                this.giftsPreferences.remove(category);
                this.giftsPreferences.add(0, category);
            } else {
                this.giftsPreferences.add(0, category);
            }
            if (this.getOldCategories().contains(category)) {
                this.oldCategories.remove(category);
                this.oldCategories.add(0, category);
            } else {
                this.oldCategories.add(0, category);
            }
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

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double score) {
        this.niceScore = score;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public ArrayList<Present> getPresentsReceived() {
        return presentsReceived;
    }

    public void setPresentsReceived(final ArrayList<Present> presentsReceived) {
        this.presentsReceived = presentsReceived;
    }

    public ArrayList<Category> getOldCategories() {
        return oldCategories;
    }

    public void setOldCategories(final ArrayList<Category> oldCategories) {
        this.oldCategories = oldCategories;
    }

    /**
     * Sterge o categorie din lista de preferinte
     * @param category
     */
    public void deleteCategory(final Category category) {
        this.giftsPreferences.remove(category);
    }

    /**
     * Stabileste categoria de varsta
     */
    public void setAgeCategory() {
        if (this.age < BABY_LIMIT) {
            this.ageCategory = AgeCategory.BABY;
        } else if (this.age < KID_LIMIT) {
            this.ageCategory = AgeCategory.KID;
        } else if (this.age <= TEEN_LIMIT) {
            this.ageCategory = AgeCategory.TEEN;
        } else {
            this.ageCategory = AgeCategory.YOUNG_ADULT;
        }
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    /***
     * Incrementeaza varsta copilului cu un an
     */
    public void addOneYear() {
        this.age++;
    }
}

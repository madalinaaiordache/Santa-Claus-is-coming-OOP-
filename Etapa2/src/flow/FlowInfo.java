package flow;

import enums.AgeCategory;
import enums.Category;
import enums.Cities;
import factory.Present;
import factory.PresentFactory;
import objects.AnnualChange;
import objects.Child;
import objects.ChildUpdate;
import objects.Input;
import strategy.CitiesStrategy;
import strategy.IdStrategy;
import strategy.NiceScoreStrategy;
import strategy.Strategy;

import java.util.ArrayList;

public final class FlowInfo {
    private int numberOfYears;
    private Double santaBudget;
    private ArrayList<Child> children;
    private PresentFactory presentFactory;
    private ArrayList<Cities> cities;
    private ArrayList<AnnualChange> annualChanges;
    private Strategy strategy;

    public ArrayList<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final ArrayList<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public FlowInfo(final Input input,
                    final PresentFactory presentFactory) {
        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();
        this.children = input.getInitialData().getChildren();
        this.presentFactory = presentFactory;
        this.annualChanges = input.getAnnualChanges();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Creeaza strategia in functie de tipul rundei
     * @param strategyString
     */
    public void strategyPicker(final String strategyString) {
        if (strategyString.equals("id")) {
            this.strategy = new IdStrategy();
        } else if (strategyString.equals("niceScore")) {
            this.strategy = new NiceScoreStrategy();
        } else if (strategyString.equals("niceScoreCity")) {
            this.strategy = new CitiesStrategy();
        }
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<Child> children) {
        this.children = children;
    }

    public PresentFactory getPresentFactory() {
        return presentFactory;
    }

    public void setPresentFactory(final PresentFactory presentFactory) {
        this.presentFactory = presentFactory;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    public void setCities(final ArrayList<Cities> cities) {
        this.cities = cities;
    }

    /**
     * Adauga un copil in lista de copii, daca nu este Young Adult
     * @param child
     */
    public void addChild(final Child child) {
        child.setAgeCategory();
        if (!child.getAgeCategory().equals(AgeCategory.YOUNG_ADULT)) {
            this.children.add(child);
        }
    }

    /**
     * Actualizeaza informatii despre toti copiii, daca e cazul
     * @param childUpdates
     */
    public void updateChildren(final ArrayList<ChildUpdate> childUpdates) {
        for (ChildUpdate update : childUpdates) {
            for (Child child : this.children) {
                if (child.getId() == update.getId()) {
                    if (update.getNiceScore() != null) {
                        child.addNiceScore(update.getNiceScore());
                    }
                    child.addGiftPreference(update.getGiftsPreferences());
                    child.setElf(update.getElf());
                }
            }
        }
    }

    /**
     * Calculeaza budget unit
     * @return
     */
    public Double calculateSantaBudgetUnit() {
        double sum = 0;
        for (Child child : this.children) {
            sum += child.getNiceScore();
        }

        double budgetUnit = this.santaBudget / sum;
        return budgetUnit;
    }

    /**
     * Imparte cadourile potrivite unui copil
     * @param child = copilul caruia imparte
     */
    public void giveChildPresents(final Child child) {
        double budget = child.getSantaBudget();
        int it = 0;
        while (budget > 0) {
            if (child.getGiftsPreferences() != null) {
                if (child.getGiftsPreferences().size() == it) {
                    break;
                }
                Category preference = child.getGiftsPreferences().get(it);
                Present newGift = this.checkForPresent(budget, preference);
                if (newGift != null) {
                    child.addGift(newGift);
                    budget -= newGift.getPrice();
                }
                it++;

            }
        }
    }

    private Present checkForPresent(final double budget,
                                    final Category category) {
        Present cheapestPresent = presentFactory.getCheapestPresent(category);
        if (cheapestPresent != null) {
            double price = cheapestPresent.getPrice();
            int quantity = cheapestPresent.getQuantity();
            if (budget > price && quantity > 0) {
                presentFactory.decreaseQuantity(cheapestPresent);
                return cheapestPresent;
            }
        }
        return null;
    }
}

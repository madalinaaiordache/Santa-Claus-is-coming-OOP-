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

import java.util.ArrayList;

public final class FlowInfo {
    private int numberOfYears;
    private Double santaBudget;
    private ArrayList<Child> children;
    private PresentFactory presentFactory;
    private ArrayList<Cities> cities;
    private ArrayList<AnnualChange> annualChanges;

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
                if (this.checkForPresent(budget, preference) != null) {
                    Present newGift = this.checkForPresent(budget, preference);
                    child.addGift(newGift);
                    budget -= newGift.getPrice();
                }
                it++;

            }
        }
    }

    private Present checkForPresent(final double budget,
                                    final Category category) {
        if (category.equals(Category.BOARD_GAMES)) {
            if (this.getPresentFactory().getBoardGamesPresents().size() != 0) {
                double price = this.getPresentFactory().
                        getBoardGamesPresents().get(0).getPrice();
                if (budget > price) {
                    return this.getPresentFactory().
                            getBoardGamesPresents().get(0);
                }
            }
        } else if (category.equals(Category.BOOKS)) {
            if (this.getPresentFactory().getBooksPresents().size() != 0) {
                double price = this.getPresentFactory().
                        getBooksPresents().get(0).getPrice();
                if (budget > price) {
                    return this.getPresentFactory().
                            getBooksPresents().get(0);
                }
            }
        } else if (category.equals(Category.CLOTHES)) {
            if (this.getPresentFactory().getClothesPresents().size() != 0) {
                double price = this.getPresentFactory().
                        getClothesPresents().get(0).getPrice();
                if (budget > price) {
                    return this.getPresentFactory().
                            getClothesPresents().get(0);
                }
            }
        } else if (category.equals(Category.SWEETS)) {
            if (this.getPresentFactory().getSweetPresents().size() != 0) {
                double price = this.getPresentFactory().
                        getSweetPresents().get(0).getPrice();
                if (budget > price) {
                    return this.getPresentFactory().
                            getSweetPresents().get(0);
                }
            }
        } else if (category.equals(Category.TECHNOLOGY)) {
            if (this.getPresentFactory().getTechnologyPresents().size() != 0) {
                double price = this.getPresentFactory().
                        getTechnologyPresents().get(0).getPrice();
                if (budget > price) {
                    return this.getPresentFactory().
                            getTechnologyPresents().get(0);
                }
            }
        } else if (category.equals(Category.TOYS)) {
            if (this.getPresentFactory().getToyPresents().size() != 0) {
                double price = this.getPresentFactory().
                        getToyPresents().get(0).getPrice();
                if (budget > price) {
                    return this.getPresentFactory().
                            getToyPresents().get(0);
                }
            }
        }
        return null;
    }
}

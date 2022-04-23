package objects;

import java.util.ArrayList;

public final class Input {
    private int numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private ArrayList<AnnualChange> annualChanges = new ArrayList<>();

    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.initialData = null;
        this.annualChanges = null;
    }

    public Input(final int numberOfYears, final Double santaBudget,
                    final InitialData initialData,
                        final ArrayList<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
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

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public ArrayList<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final ArrayList<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}

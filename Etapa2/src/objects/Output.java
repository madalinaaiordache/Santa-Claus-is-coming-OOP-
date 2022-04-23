package objects;

import java.util.ArrayList;

public final class Output {
    private ArrayList<OutputChildren> annualChildren;

    public Output() {
        this.annualChildren = new ArrayList<>();
    }

    public Output(final ArrayList<OutputChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public ArrayList<OutputChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final ArrayList<OutputChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }
}

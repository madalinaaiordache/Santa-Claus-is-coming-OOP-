package objects;

import java.util.ArrayList;

public final class OutputChildren {

    private ArrayList<ChildOutput> children;

    public OutputChildren() {
        this.children = new ArrayList<>();
    }

    public OutputChildren(final ArrayList<ChildOutput> annualChildren) {
        this.children = annualChildren;
    }

    public ArrayList<ChildOutput> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildOutput> annualChildren) {
        this.children = annualChildren;
    }
}

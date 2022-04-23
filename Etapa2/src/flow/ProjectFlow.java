package flow;

import enums.AgeCategory;
import enums.Category;
import objects.AnnualChange;
import objects.Child;
import objects.ChildOutput;
import objects.Output;
import objects.OutputChildren;

import java.util.ArrayList;

public final class ProjectFlow {

    private FlowInfo flowInfo;

    public ProjectFlow(final FlowInfo info) {
        this.flowInfo = info;
    }

    public FlowInfo getFlowInfo() {
        return flowInfo;
    }

    public void setFlowInfo(final FlowInfo flowInfo) {
        this.flowInfo = flowInfo;
    }

    /**
     * Itereaza toti anii pentru un input
     * @return
     */
    public Output runAllYears() {
        Output finalResults = new Output();
        String roundStrategy = "id";
        for (int i = 0; i <= this.flowInfo.getNumberOfYears(); i++) {
            for (int j = 0; j < this.flowInfo.getChildren().size(); j++) {
                Child child = this.flowInfo.getChildren().get(j);
                // se incrementeaza cu un an varsta daca nu suntem in runda initiala
                if (i != 0) {
                    child.addOneYear();
                }

                // se seteaza categoria de varsta si se elimina cei peste 18 ani
                child.setAgeCategory();
                if (child.getAgeCategory().equals(AgeCategory.YOUNG_ADULT)) {
                    this.flowInfo.getChildren().remove(child);
                    j--;
                }
            }

            if (i != 0) {
                for (Child child : this.flowInfo.getChildren()) {
                    child.newRoundChild();
                }
            }

            // se citesc update-urile daca nu e runda initiala
            if (i != 0) {
                AnnualChange changes = flowInfo.getAnnualChanges().get(i - 1);
                this.flowInfo.setSantaBudget(changes.getNewSantaBudget());

                if (changes.getNewGifts() != null) {
                    for (int j = 0; j < changes.getNewGifts().size(); j++) {
                        this.flowInfo.getPresentFactory().insertPresent(
                                changes.getNewGifts().get(j).getProductName(),
                                changes.getNewGifts().get(j).getPrice(),
                                changes.getNewGifts().get(j).getCategory(),
                                changes.getNewGifts().get(j).getQuantity()
                        );
                    }
                }

                if (changes.getNewChildren() != null) {
                    for (int j = 0; j < changes.getNewChildren().size(); j++) {
                        Child child = changes.getNewChildren().get(j);
                        child.getNiceScoreList().add(child.getNiceScore());
                        child.setOldCategories(child.getGiftsPreferences());
                        this.flowInfo.addChild(child);
                    }
                }

                if (changes.getChildrenUpdates() != null) {
                    this.flowInfo.updateChildren(changes.getChildrenUpdates());
                }
                roundStrategy = changes.getStrategy();
            }
            this.flowInfo.strategyPicker(roundStrategy);

            // bag scorul initial si copiez lista de preferinte in runda initiala
            if (i == 0) {
                for (Child child : this.flowInfo.getChildren()) {
                    child.getNiceScoreList().add(child.getNiceScore());
                    for (Category categ : child.getGiftsPreferences()) {
                        child.getOldCategories().add(categ);
                    }
                }
            }

            // se calculeaza scorul si bugetul si se aplica modificatile elfilor
            for (Child child : this.flowInfo.getChildren()) {
                child.calculateNiceScore();
            }

            double budgetUnit = this.flowInfo.calculateSantaBudgetUnit();
            for (Child child : this.flowInfo.getChildren()) {
                child.calculateSantaBudget(budgetUnit);
                child.applyElfChanges();
            }

            // se dau cadourile
            this.flowInfo.getPresentFactory().sortPresents();
            for (Child child : this.flowInfo.getChildren()) {
                child.setPresentsReceived(new ArrayList<>());
            }
            this.flowInfo.getStrategy().shareGifts(this.flowInfo);
            // elfii yellow mai dau o data cadouri
            for (Child child : this.flowInfo.getChildren()) {
                child.yellowShare(this.flowInfo.getPresentFactory());
            }

            OutputChildren childrenOut = new OutputChildren();
            for (Child child : this.flowInfo.getChildren()) {
                ChildOutput toAdd = new ChildOutput(child.getId(),
                        child.getLastName(), child.getFirstName(),
                        child.getCity(), child.getAge(),
                        child.getOldCategories(), child.getNiceScore(),
                        child.getNiceScoreList(), child.getSantaBudget(),
                        child.getPresentsReceived());
                childrenOut.getChildren().add(toAdd);
            }
            finalResults.getAnnualChildren().add(childrenOut);
        }
    return finalResults;
    }
}

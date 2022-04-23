package strategy;

import flow.FlowInfo;
import objects.Child;
import observer.CityAverageCalculator;

import java.util.Collections;

public final class CitiesStrategy implements Strategy {
    @Override
    public void shareGifts(final FlowInfo flowInfo)  {
        CityAverageCalculator calculator = new CityAverageCalculator(flowInfo.getChildren());
        calculator.calculateAverages();

        Collections.sort(flowInfo.getChildren(), new SortByCity());
        for (Child kid : flowInfo.getChildren()) {
            flowInfo.giveChildPresents(kid);
        }
        Collections.sort(flowInfo.getChildren(), new SortById());

    }
}

package strategy;

import flow.FlowInfo;
import objects.Child;

import java.util.Collections;

public final class IdStrategy implements Strategy {

    @Override
    public void shareGifts(final FlowInfo flowInfo)  {
        Collections.sort(flowInfo.getChildren(), new SortById());
        for (Child kid : flowInfo.getChildren()) {
            flowInfo.giveChildPresents(kid);
        }
    }
}



package strategy;

import flow.FlowInfo;
import objects.Child;

import java.util.Collections;

public final class NiceScoreStrategy implements Strategy {
    @Override
    public void shareGifts(final FlowInfo flowInfo) {
        Collections.sort(flowInfo.getChildren(), new SortByNiceScore());
        for (Child kid : flowInfo.getChildren()) {
            flowInfo.giveChildPresents(kid);
        }
        Collections.sort(flowInfo.getChildren(), new SortById());
    }
}

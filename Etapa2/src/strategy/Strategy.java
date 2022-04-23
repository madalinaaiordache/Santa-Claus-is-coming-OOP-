package strategy;

import flow.FlowInfo;

public interface Strategy {

    /**
     * Metoda pentru impartirea cadourilor, in functie de strategie
     */
     void shareGifts(FlowInfo flowInfo);
}

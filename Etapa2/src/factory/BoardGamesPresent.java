package factory;

import enums.Category;

public final class BoardGamesPresent extends Present {
    public BoardGamesPresent(final String productName, final Double price,
                             final Category category, final int quantity) {
        super(productName, price, category, quantity);
    }
}

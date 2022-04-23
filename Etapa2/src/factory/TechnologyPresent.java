package factory;

import enums.Category;

public final class TechnologyPresent extends Present {
    public TechnologyPresent(final String productName, final Double price,
                             final Category category, final int quantity) {
        super(productName, price, category, quantity);
    }
}

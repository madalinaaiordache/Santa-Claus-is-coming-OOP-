package factory;

import enums.Category;

public final class TechnologyPresent extends Present {
    public TechnologyPresent(final String productName, final Double price,
                             final Category category) {
        super(productName, price, category);
    }
}

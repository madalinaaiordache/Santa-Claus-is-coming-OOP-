package factory;

import enums.Category;

public final class ToyPresent extends Present {
    public ToyPresent(final String productName, final Double price,
                      final Category category, final int quantity) {
        super(productName, price, category, quantity);
    }
}

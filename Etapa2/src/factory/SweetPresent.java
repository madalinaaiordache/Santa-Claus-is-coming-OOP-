package factory;

import enums.Category;

public final class SweetPresent extends Present {
    public SweetPresent(final String productName, final Double price,
                        final Category category, final int quantity) {
        super(productName, price, category, quantity);
    }
}

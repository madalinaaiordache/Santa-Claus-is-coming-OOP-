package factory;

import enums.Category;

public final class SweetPresent extends Present {
    public SweetPresent(final String productName, final Double price,
                        final Category category) {
        super(productName, price, category);
    }
}

package factory;

import enums.Category;

public final  class ClothesPresent extends Present {
    public ClothesPresent(final String productName, final Double price,
                          final Category category, final int quantity) {
        super(productName, price, category, quantity);
    }
}

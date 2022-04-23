package factory;

import enums.Category;

public final class BooksPresent extends Present {

    public BooksPresent(final String productName,
                        final Double price, final Category category,
                        final int quantity) {
        super(productName, price, category, quantity);
    }
}

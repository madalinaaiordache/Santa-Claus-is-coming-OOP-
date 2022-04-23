package factory;

import enums.Category;

public final class BooksPresent extends Present {

    public BooksPresent(final String productName,
                        final Double price, final Category category) {
        super(productName, price, category);
    }
}

package factory;

import enums.Category;
import objects.PresentInput;

public abstract class Present extends PresentInput {
    public Present(final String productName, final Double price,
                   final Category category, final int quantity) {
        super(productName, price, category, quantity);
    }
}

package objects;

import enums.Category;

public class PresentInput {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

    public PresentInput() {
        this.productName = null;
        this.price = 0.0;
        this.category = null;
        this.quantity = 0;
    }
    public PresentInput(final String productName, final Double price,
                        final Category category, final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final void setPrice(final Double price) {
        this.price = price;
    }

    public final Category getCategory() {
        return category;
    }

    public final void setCategory(final Category category) {
        this.category = category;
    }
}

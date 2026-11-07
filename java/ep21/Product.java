class Product {
    private String name;
    private int priceCents;

    Product(String name, int priceCents) {
        this.name = name;
        setPriceCents(priceCents);
    }

    String getName() {
        return name;
    }

    int getPriceCents() {
        return priceCents;
    }

    void setPriceCents(int newPriceCents) {
        if (newPriceCents < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        priceCents = newPriceCents;
    }
}

class Product {
    static final int MAX_PRICE_CENTS = 100_000;
    private static int createdCount = 0;

    private String name;
    private int priceCents;

    Product(String name, int priceCents) {
        this.name = name;
        setPriceCents(priceCents);
        createdCount++;
    }

    static int getCreatedCount() {
        return createdCount;
    }

    static boolean isValidPrice(int priceCents) {
        return priceCents >= 0 && priceCents <= MAX_PRICE_CENTS;
    }

    String getName() {
        return name;
    }

    int getPriceCents() {
        return priceCents;
    }

    String describe() {
        return name + ": " + priceCents;
    }

    void setPriceCents(int newPriceCents) {
        if (!isValidPrice(newPriceCents)) {
            throw new IllegalArgumentException("price out of range");
        }
        priceCents = newPriceCents;
    }
}

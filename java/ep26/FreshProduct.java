class FreshProduct extends Product {
    private int daysLeft;

    FreshProduct(String name, int priceCents, int daysLeft) {
        super(name, priceCents);
        this.daysLeft = daysLeft;
    }

    int getDaysLeft() {
        return daysLeft;
    }

    @Override
    String describe() {
        return super.describe() + ", " + daysLeft + " days left";
    }
}

class NoDiscount implements Discount {
    public int apply(int priceCents) {
        return priceCents;
    }
}

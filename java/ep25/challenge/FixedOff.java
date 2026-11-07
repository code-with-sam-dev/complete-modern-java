class FixedOff implements Discount {
    private int amountCents;

    FixedOff(int amountCents) {
        this.amountCents = amountCents;
    }

    public int apply(int priceCents) {
        int result = priceCents - amountCents;
        if (result < 0) {
            return 0;
        }
        return result;
    }
}

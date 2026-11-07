class PercentOff implements Discount {
    private int percent;

    PercentOff(int percent) {
        this.percent = percent;
    }

    public int apply(int priceCents) {
        return priceCents - priceCents * percent / 100;
    }
}

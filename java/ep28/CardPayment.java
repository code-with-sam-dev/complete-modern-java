class CardPayment extends PaymentMethod {
    CardPayment() {
        super("Card");
    }

    @Override
    int feeCents(int priceCents) {
        return priceCents * 2 / 100;
    }
}

class CashPayment extends PaymentMethod {
    CashPayment() {
        super("Cash");
    }

    @Override
    int feeCents(int priceCents) {
        return 0;
    }
}

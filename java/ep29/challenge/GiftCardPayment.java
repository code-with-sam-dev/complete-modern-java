// One possible answer to the Episode 29 challenge: a fourth payment type, added without changing totalFor.
class GiftCardPayment extends PaymentMethod {
    GiftCardPayment() {
        super("Gift card");
    }

    @Override
    int feeCents(int priceCents) {
        return 25;
    }
}

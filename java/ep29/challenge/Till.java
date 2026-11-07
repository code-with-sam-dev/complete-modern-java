void main() {
    IO.println(totalFor(new CardPayment(), 1000));
    IO.println(totalFor(new CashPayment(), 1000));
    IO.println(totalFor(new VoucherPayment(), 1000));
    IO.println(totalFor(new GiftCardPayment(), 1000));
}

int totalFor(PaymentMethod method, int priceCents) {
    return method.totalCents(priceCents);
}

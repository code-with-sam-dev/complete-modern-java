void main() {
    IO.println(totalFor(new CardPayment(), 1000));
    IO.println(totalFor(new CashPayment(), 1000));
    IO.println(totalFor(new VoucherPayment(), 1000));
    PaymentMethod method = new CardPayment();
    IO.println(method.totalCents(1000));
    method = new CashPayment();
    IO.println(method.totalCents(1000));
}

int totalFor(PaymentMethod method, int priceCents) {
    return method.totalCents(priceCents);
}

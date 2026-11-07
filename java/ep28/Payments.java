void main() {
    PaymentMethod payment = new CardPayment();
    IO.println(payment.totalCents(1000));
    ArrayList<PaymentMethod> methods = new ArrayList<>();
    methods.add(new CardPayment());
    methods.add(new CashPayment());
    for (PaymentMethod method : methods) {
        IO.println(method.getName() + ": " + method.totalCents(1000));
    }
}

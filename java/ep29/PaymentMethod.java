abstract class PaymentMethod {
    private String name;

    PaymentMethod(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract int feeCents(int priceCents);

    int totalCents(int priceCents) {
        return priceCents + feeCents(priceCents);
    }
}

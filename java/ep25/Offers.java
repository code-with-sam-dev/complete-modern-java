void main() {
    Discount offer = new NoDiscount();
    IO.println(offer.apply(1000));
    offer = new PercentOff(10);
    IO.println(offer.apply(1000));
    offer = new PercentOff(50);
    IO.println(offer.apply(1000));
    printTotal(499, new NoDiscount());
    printTotal(499, new PercentOff(10));
    printTotal(499, new PercentOff(50));
}

void printTotal(int priceCents, Discount discount) {
    IO.println("Total: " + discount.apply(priceCents));
}

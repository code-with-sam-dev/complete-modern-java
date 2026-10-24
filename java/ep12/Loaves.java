void main() {
    int totalCents = 0;
    int breadPriceCents = 150;
    for (int i = 1; i <= 3; i++) {
        totalCents += breadPriceCents;
    }
    IO.println(totalCents);
}
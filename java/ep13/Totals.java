void main() {
    int breadTotal = lineTotal(2, 150);
    int milkTotal = lineTotal(1, 99);
    IO.println(breadTotal);
    IO.println(breadTotal + milkTotal);
}

int lineTotal(int quantity, int priceCents) {
    return quantity * priceCents;
}
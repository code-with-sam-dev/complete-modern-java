// FixedOff keeps the Discount promise. printTotal is exactly the same as in the episode: it did not change.
void main() {
    printTotal(1000, new FixedOff(100));
    printTotal(50, new FixedOff(100));
}

void printTotal(int priceCents, Discount discount) {
    IO.println("Total: " + discount.apply(priceCents));
}

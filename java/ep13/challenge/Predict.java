// Predict what this prints before you run it. The answer is in the README, Episode 13.
void main() {
    IO.println(lineTotal(3, 150) + lineTotal(2, 99));
}

int lineTotal(int quantity, int priceCents) {
    return quantity * priceCents;
}

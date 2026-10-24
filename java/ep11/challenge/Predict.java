// Predict the message for each customer before you run it. The answers are in the README, Episode 11.
// Try: 12000 and true; 6000 and false; 6000 and true.
void main() {
    int totalCents = 12000;
    boolean member = true;
    if (totalCents >= 10000) {
        IO.println("Free gift");
    } else if (totalCents >= 5000 && member) {
        IO.println("Free delivery");
    } else {
        IO.println("Delivery: $4.99");
    }
}

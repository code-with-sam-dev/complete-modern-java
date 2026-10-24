// Predict the delivery for each basket before you run it. The answers are in the README, Episode 10.
void main() {
    int totalCents = 4999;   // then try 5000, then 5001
    if (totalCents >= 5000) {
        IO.println("Free delivery");
    } else {
        IO.println("Delivery: $4.99");
    }
}

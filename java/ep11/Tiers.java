void main() {
    int totalCents = 5240;
    boolean member = true;
    if (totalCents >= 10000) {
        IO.println("Free gift");
    } else if (totalCents >= 5000 && member) {
        IO.println("Free delivery");
    } else {
        IO.println("Delivery: $4.99");
    }
}
void main() {
    int totalCents = 5240;
    IO.println(totalCents >= 5000);
    if (totalCents >= 5000) {
        IO.println("Free delivery");
    } else {
        IO.println("Delivery: $4.99");
    }
    IO.println("Thank you, Sarah");
}
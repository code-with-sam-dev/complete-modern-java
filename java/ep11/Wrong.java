void main() {
    int totalCents = 12000;
    boolean member = true;
    if (totalCents >= 5000 && member) {
        IO.println("Free delivery");
    } else if (totalCents >= 10000) {
        IO.println("Free gift");
    }
}
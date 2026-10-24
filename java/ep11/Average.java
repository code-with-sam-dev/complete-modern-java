void main() {
    int items = 0;
    int totalCents = 5000;
    if (items > 0 && totalCents / items > 1000) {
        IO.println("Average above $10");
    } else {
        IO.println("No qualifying average");
    }
    boolean member = false;
    IO.println(member || (totalCents >= 5000 && items > 0));
}
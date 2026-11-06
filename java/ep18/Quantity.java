void main() {
    String typed = "two";
    try {
        int quantity = Integer.parseInt(typed);
        IO.println("Quantity: " + quantity);
    } catch (NumberFormatException e) {
        IO.println("Not a number: " + typed);
    }
}

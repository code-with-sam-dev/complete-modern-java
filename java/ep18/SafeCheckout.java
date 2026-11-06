void main() {
    try {
        Product eggs = new Product("Eggs", -5);
        IO.println("Added " + eggs.getName());
    } catch (IllegalArgumentException e) {
        IO.println("Could not add eggs: " + e.getMessage());
    }
    IO.println("Checkout continues");
}

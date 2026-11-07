// Predict both lines before you run it. The answers are in the README, Episode 20.
void main() {
    ShoppingCart cart = new ShoppingCart();
    cart.add(new Product("Bread", 150));
    cart.add(new Product("Milk", 99));
    cart.add(new Product("Eggs", 250));
    cart.add(new Product("Rice", 199));
    IO.println(cart.count());
    IO.println(cart.totalCents());
}

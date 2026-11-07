// Predict the names left in the cart before you run it. The answer is in the README, Episode 21.
void main() {
    ShoppingCart cart = new ShoppingCart();
    cart.add(new Product("Milk", 99));
    cart.add(new Product("Eggs", 250));
    cart.add(new Product("Milk", 99));
    cart.add(new Product("Bread", 150));
    cart.removeByName("Milk");
    cart.printNames();
}

void main() {
    ShoppingCart cart = new ShoppingCart();
    IO.println(cart.totalCents());
    cart.add(new Product("Bread", 150));
    cart.add(new Product("Milk", 99));
    cart.add(new Product("Eggs", 250));
    IO.println(cart.count());
    IO.println(cart.totalCents());
}

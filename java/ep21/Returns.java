void main() {
    ShoppingCart cart = new ShoppingCart();
    Product milk = new Product("Milk", 99);
    cart.add(new Product("Bread", 150));
    cart.add(milk);
    cart.add(new Product("Eggs", 250));
    cart.printNames();
    IO.println(cart.remove(new Product("Milk", 99)));
    IO.println(cart.count());
    IO.println(cart.remove(milk));
    IO.println(cart.count());
    IO.println(cart.totalCents());
    IO.println(cart.removeByName("Eggs"));
    IO.println(cart.removeByName("Rice"));
    IO.println(cart.totalCents());
}

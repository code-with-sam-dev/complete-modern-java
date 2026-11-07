void main() {
    ShoppingCart cart = new ShoppingCart();
    cart.add(new Product("Rice", 199));
    cart.add(new FreshProduct("Milk", 99, 3));
    IO.println(cart.count());
    IO.println(cart.totalCents());
    Trolley trolley = new Trolley();
    trolley.add(new Product("Rice", 199));
    trolley.add(null);
    IO.println(trolley.size());
    trolley.clear();
    IO.println(trolley.size());
}

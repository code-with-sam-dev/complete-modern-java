void main() {
    FreshProduct milk = new FreshProduct("Milk", 99, 3);
    IO.println(milk.getName());
    IO.println(milk.getPriceCents());
    IO.println(milk.getDaysLeft());
    IO.println(milk.describe());
    ArrayList<Product> shelf = new ArrayList<>();
    shelf.add(new Product("Rice", 199));
    shelf.add(milk);
    for (Product product : shelf) {
        IO.println(product.describe());
    }
}

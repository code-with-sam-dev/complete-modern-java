void main() {
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product("Bread", 150));
    products.add(new Product("Milk", 99));
    products.add(new Product("Eggs", 250));
    int total = 0;
    for (Product product : products) {
        total += product.getPriceCents();
    }
    IO.println(total);
}

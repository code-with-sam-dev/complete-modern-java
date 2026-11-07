void main() {
    IO.println(Product.getCreatedCount());
    Product bread = new Product("Bread", 150);
    Product milk = new Product("Milk", 99);
    IO.println(Product.getCreatedCount());
    IO.println(Product.MAX_PRICE_CENTS);
    IO.println(Product.isValidPrice(150));
    IO.println(Product.isValidPrice(150_000));
    IO.println(bread.getName());
}

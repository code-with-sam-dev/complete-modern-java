class Product {
    String name;
    int priceCents;
}

void main() {
    Product bread = new Product();
    IO.println(bread.name);
    IO.println(bread.priceCents);
    bread.name = "Bread";
    bread.priceCents = 150;
    IO.println(bread.name);
}

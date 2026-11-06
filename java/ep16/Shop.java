class Product {
    String name;
    int priceCents;
    Product(String name, int priceCents) {
        this.name = name;
        this.priceCents = priceCents;
    }
    String label() {
        return name + ": " + priceCents + " cents";
    }
}

void main() {
    Product bread = new Product("Bread", 150);
    IO.println(bread.name);
    Product milk = new Product("Milk", 99);
    IO.println(bread.label());
    IO.println(milk.label());
    Product[] basket = {bread, milk};
    int total = 0;
    for (Product p : basket) {
        total += p.priceCents;
    }
    IO.println(total);
}

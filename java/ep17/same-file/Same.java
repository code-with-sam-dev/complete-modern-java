class Product {
    private int priceCents;

    Product(int priceCents) {
        this.priceCents = priceCents;
    }
}

void main() {
    Product bread = new Product(150);
    bread.priceCents = -5;
    IO.println(bread.priceCents);
}

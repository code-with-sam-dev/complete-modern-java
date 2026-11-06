// Predict both lines before you run it. The answers are in the README, Episode 16.
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
    Product first = new Product("Bread", 150);
    Product second = new Product("Milk", 99);
    first.name = "Toast";
    IO.println(first.label());
    IO.println(second.label());
}

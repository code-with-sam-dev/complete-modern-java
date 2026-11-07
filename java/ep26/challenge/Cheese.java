// Add cheese, a FreshProduct at 350 cents with 5 days left, print its name with the inherited getter, then predict the
// loop's new line before you run it. The answer is in the README, Episode 26.
void main() {
    FreshProduct milk = new FreshProduct("Milk", 99, 3);
    FreshProduct cheese = new FreshProduct("Cheese", 350, 5);
    IO.println(cheese.getName());
    ArrayList<Product> shelf = new ArrayList<>();
    shelf.add(new Product("Rice", 199));
    shelf.add(milk);
    shelf.add(cheese);
    for (Product product : shelf) {
        IO.println(product.describe());
    }
}

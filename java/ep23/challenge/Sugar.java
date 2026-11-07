// Add Sugar at 180, then predict what the values loop adds up to. The answer is in the README, Episode 23.
void main() {
    HashMap<String, Product> catalog = new HashMap<>();
    catalog.put("Bread", new Product("Bread", 150));
    catalog.put("Milk", new Product("Milk", 99));
    catalog.put("Eggs", new Product("Eggs", 250));
    catalog.put("Rice", new Product("Rice", 199));
    catalog.put("Sugar", new Product("Sugar", 180));
    int totalCents = 0;
    for (Product product : catalog.values()) {
        totalCents += product.getPriceCents();
    }
    IO.println(totalCents);
}

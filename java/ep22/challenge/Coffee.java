// Your challenge: add Coffee at 350, print its price by name, then look up Tea (not in the catalog) without
// crashing. One way to do it is in the README, Episode 22.
void main() {
    HashMap<String, Product> catalog = new HashMap<>();
    catalog.put("Milk", new Product("Milk", 99));
    catalog.put("Coffee", new Product("Coffee", 350));
    IO.println(catalog.get("Coffee").getPriceCents());
    if (catalog.containsKey("Tea")) {
        IO.println(catalog.get("Tea").getPriceCents());
    } else {
        IO.println("Tea is not in the catalog");
    }
}

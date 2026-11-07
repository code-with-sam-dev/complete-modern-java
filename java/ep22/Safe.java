void main() {
    HashMap<String, Product> catalog = new HashMap<>();
    catalog.put("Milk", new Product("Milk", 99));
    if (catalog.containsKey("Rice")) {
        Product rice = catalog.get("Rice");
        IO.println(rice.getPriceCents());
    } else {
        IO.println("Rice is not in the catalog");
    }
}

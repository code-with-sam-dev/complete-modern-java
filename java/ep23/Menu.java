void main() {
    HashMap<String, Product> catalog = new HashMap<>();
    catalog.put("Bread", new Product("Bread", 150));
    catalog.put("Milk", new Product("Milk", 99));
    catalog.put("Eggs", new Product("Eggs", 250));
    catalog.put("Rice", new Product("Rice", 199));
    for (String name : catalog.keySet()) {
        Product product = catalog.get(name);
        IO.println(name + ": " + product.getPriceCents());
    }
    int totalCents = 0;
    for (Product product : catalog.values()) {
        totalCents += product.getPriceCents();
    }
    IO.println(totalCents);
    for (Map.Entry<String, Product> entry : catalog.entrySet()) {
        IO.println(entry.getKey() + " costs " + entry.getValue().getPriceCents());
    }
}

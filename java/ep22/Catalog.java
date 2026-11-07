void main() {
    HashMap<String, Product> catalog = new HashMap<>();
    catalog.put("Bread", new Product("Bread", 150));
    catalog.put("Milk", new Product("Milk", 99));
    catalog.put("Eggs", new Product("Eggs", 250));
    IO.println(catalog.size());
    Product milk = catalog.get("Milk");
    IO.println(milk.getPriceCents());
    catalog.put("Milk", new Product("Milk", 120));
    IO.println(catalog.get("Milk").getPriceCents());
    IO.println(catalog.size());
    catalog.remove("Eggs");
    IO.println(catalog.size());
    IO.println(catalog.containsKey("Rice"));
    Product rice = catalog.get("Rice");
    IO.println(rice);
    IO.println(rice.getPriceCents());
}

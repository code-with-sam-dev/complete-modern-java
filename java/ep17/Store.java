void main() {
    Product bread = new Product("Bread", 150);
    IO.println(bread.getName());
    IO.println(bread.getPriceCents());
    bread.setPriceCents(200);
    IO.println(bread.getPriceCents());
    Product eggs = new Product("Eggs", -5);
    IO.println(eggs.getPriceCents());
}

void main() {
    Product first = new Product("Milk", 99);
    Product second = new Product("Milk", 99);
    IO.println(first == second);
    IO.println(first.equals(second));
    IO.println("Milk".equals("Milk"));
}

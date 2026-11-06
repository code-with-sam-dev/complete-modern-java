void main() {
    ArrayList<String> basket = new ArrayList<>();
    basket.add("Bread");
    basket.add("Milk");
    basket.add("Eggs");
    IO.println(basket);
    IO.println(basket.size());
    IO.println(basket.get(0));
    basket.remove("Milk");
    IO.println(basket);
    IO.println(basket.contains("Milk"));
    for (String item : basket) {
        IO.println(item);
    }
    IO.println(basket.get(5));
}

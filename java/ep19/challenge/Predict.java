// Predict both lines before you run it. The answers are in the README, Episode 19.
void main() {
    ArrayList<String> basket = new ArrayList<>();
    basket.add("Bread");
    basket.add("Milk");
    basket.add("Eggs");
    basket.remove("Milk");
    basket.add("Rice");
    IO.println(basket.size());
    IO.println(basket.get(1));
}

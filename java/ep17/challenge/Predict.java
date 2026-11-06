// Which of the two marked lines compiles? Remove the comment marks one at a time and run it.
// The answer is in the README, Episode 17.
void main() {
    Product bread = new Product("Bread", 150);
    // bread.setPriceCents(300);
    // bread.priceCents = 300;
    IO.println(bread.getPriceCents());
}

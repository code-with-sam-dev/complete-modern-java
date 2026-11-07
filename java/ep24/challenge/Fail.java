// Make a product at 150_000 cents inside a try, catch the exception, then print getCreatedCount(). Predict first: the answer is in the README, Episode 24.
void main() {
    try {
        Product gold = new Product("Gold", 150_000);
    } catch (IllegalArgumentException e) {
        IO.println(e.getMessage());
    }
    IO.println(Product.getCreatedCount());
}

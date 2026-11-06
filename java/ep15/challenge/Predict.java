// Predict the total before you run it: 1000 or 900? The answer is in the README, Episode 15.
void main() {
    int[] prices = {100, 200, 300, 400};
    int total = 0;
    for (int i = 1; i < prices.length; i++) {
        total += prices[i];
    }
    IO.println(total);
}

void main() {
    int[] prices = {150, 99, 250};
    int total = 0;
    for (int i = 0; i < prices.length; i++) {
        total += prices[i];
    }
    IO.println(total);
    int sum = 0;
    for (int price : prices) {
        sum += price;
    }
    IO.println(sum);
}

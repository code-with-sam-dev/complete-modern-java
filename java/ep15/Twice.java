import java.util.Arrays;

void main() {
    int[] prices = {150, 99, 250};
    for (int price : prices) {
        price = price * 2;
    }
    IO.println(Arrays.toString(prices));
    for (int i = 0; i < prices.length; i++) {
        prices[i] = prices[i] * 2;
    }
    IO.println(Arrays.toString(prices));
}

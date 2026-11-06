// Predict the output before you run it. The answer is in the README, Episode 18.
void main() {
    try {
        IO.println("One");
        Integer.parseInt("two");
        IO.println("Two");
    } catch (NumberFormatException e) {
        IO.println("Caught");
    }
    IO.println("Three");
}

import java.math.BigDecimal;

void main() {
    IO.println(1.10 + 2.20);
    IO.println(0.1 + 0.2 == 0.3);
    IO.println(0.1);
    IO.println(new BigDecimal(0.1));
    IO.println(new BigDecimal("0.1"));
    BigDecimal bread = new BigDecimal("1.10");
    BigDecimal milk = new BigDecimal("2.20");
    BigDecimal total = bread.add(milk);
    IO.println(total);
}
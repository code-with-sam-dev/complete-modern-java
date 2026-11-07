// Make VoucherPayment work without changing PaymentMethod, then predict the total for 1000 cents.
// The answer is in the README, Episode 28.
void main() {
    PaymentMethod voucher = new VoucherPayment();
    IO.println(voucher.getName() + ": " + voucher.totalCents(1000));
}

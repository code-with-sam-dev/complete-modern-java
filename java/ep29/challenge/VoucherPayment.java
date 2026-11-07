class VoucherPayment extends PaymentMethod {
    VoucherPayment() {
        super("Voucher");
    }

    @Override
    int feeCents(int priceCents) {
        return 50;
    }
}

void main() {
    IO.println(totalFor("card", 1000));
    IO.println(totalFor("cash", 1000));
    IO.println(totalFor("voucher", 1000));
}

int totalFor(String type, int priceCents) {
    if (type.equals("card")) {
        return priceCents + priceCents * 2 / 100;
    }
    if (type.equals("cash")) {
        return priceCents;
    }
    throw new IllegalArgumentException("unknown payment type: " + type);
}

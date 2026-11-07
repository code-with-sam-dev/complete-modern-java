abstract class PaymentMethod {
    name: string;

    constructor(name: string) {
        this.name = name;
    }

    abstract feeCents(priceCents: number): number;

    totalCents(priceCents: number): number {
        return priceCents + this.feeCents(priceCents);
    }
}

class CardPayment extends PaymentMethod {
    constructor() {
        super("Card");
    }

    feeCents(priceCents: number): number {
        return Math.floor(priceCents * 2 / 100);
    }
}

class CashPayment extends PaymentMethod {
    constructor() {
        super("Cash");
    }

    feeCents(priceCents: number): number {
        return 0;
    }
}

class VoucherPayment extends PaymentMethod {
    constructor() {
        super("Voucher");
    }

    feeCents(priceCents: number): number {
        return 50;
    }
}

function totalFor(method: PaymentMethod, priceCents: number): number {
    return method.totalCents(priceCents);
}

console.log(totalFor(new CardPayment(), 1000));
console.log(totalFor(new CashPayment(), 1000));
console.log(totalFor(new VoucherPayment(), 1000));

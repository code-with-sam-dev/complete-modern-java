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

const methods: PaymentMethod[] = [new CardPayment(), new CashPayment()];
for (const method of methods) {
    console.log(method.name + ": " + method.totalCents(1000));
}

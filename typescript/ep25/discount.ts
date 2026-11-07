interface Discount {
    apply(priceCents: number): number;
}

class NoDiscount implements Discount {
    apply(priceCents: number): number {
        return priceCents;
    }
}

class PercentOff implements Discount {
    private percent: number;

    constructor(percent: number) {
        this.percent = percent;
    }

    apply(priceCents: number): number {
        return priceCents - Math.floor(priceCents * this.percent / 100);
    }
}

function printTotal(priceCents: number, discount: Discount): void {
    console.log("Total: " + discount.apply(priceCents));
}

printTotal(499, new NoDiscount());
printTotal(499, new PercentOff(10));
printTotal(499, new PercentOff(50));

class Product {
    private priceCents: number;

    constructor(priceCents: number) {
        this.priceCents = priceCents;
    }

    getPriceCents(): number {
        return this.priceCents;
    }
}

const bread = new Product(150);
console.log(bread.getPriceCents());
console.log(bread.priceCents);

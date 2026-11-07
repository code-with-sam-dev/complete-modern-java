class Product {
    static readonly MAX_PRICE_CENTS = 100_000;
    static createdCount = 0;

    name: string;
    priceCents: number;

    constructor(name: string, priceCents: number) {
        this.name = name;
        this.priceCents = priceCents;
        Product.createdCount++;
    }
}

console.log(Product.createdCount);
const bread = new Product("Bread", 150);
const milk = new Product("Milk", 99);
console.log(Product.createdCount);
console.log(Product.MAX_PRICE_CENTS);

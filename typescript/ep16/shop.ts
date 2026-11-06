class Product {
    name: string;
    priceCents: number;
    constructor(name: string, priceCents: number) {
        this.name = name;
        this.priceCents = priceCents;
    }
    label(): string {
        return this.name + ": " + this.priceCents + " cents";
    }
}

const bread = new Product("Bread", 150);
const milk = new Product("Milk", 99);
console.log(bread.label());
console.log(milk.label());

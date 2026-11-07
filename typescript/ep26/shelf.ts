class Product {
    name: string;
    priceCents: number;

    constructor(name: string, priceCents: number) {
        this.name = name;
        this.priceCents = priceCents;
    }

    describe(): string {
        return this.name + ": " + this.priceCents;
    }
}

class FreshProduct extends Product {
    daysLeft: number;

    constructor(name: string, priceCents: number, daysLeft: number) {
        super(name, priceCents);
        this.daysLeft = daysLeft;
    }

    override describe(): string {
        return super.describe() + ", " + this.daysLeft + " days left";
    }
}

const shelf: Product[] = [new Product("Rice", 199), new FreshProduct("Milk", 99, 3)];
for (const product of shelf) {
    console.log(product.describe());
}

class Product {
    name: string;
    priceCents: number;

    constructor(name: string, priceCents: number) {
        if (priceCents < 0) {
            throw new Error("price cannot be negative");
        }
        this.name = name;
        this.priceCents = priceCents;
    }
}

try {
    const eggs = new Product("Eggs", -5);
    console.log("Added " + eggs.name);
} catch (e) {
    if (e instanceof Error) {
        console.log("Could not add eggs: " + e.message);
    }
}
console.log("Checkout continues");

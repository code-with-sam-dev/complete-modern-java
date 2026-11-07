class Product {
    name: string;
    priceCents: number;

    constructor(name: string, priceCents: number) {
        this.name = name;
        this.priceCents = priceCents;
    }
}

const catalog = new Map<string, Product>();
catalog.set("Bread", new Product("Bread", 150));
catalog.set("Milk", new Product("Milk", 99));
catalog.set("Eggs", new Product("Eggs", 250));
console.log(catalog.size);
const milk = catalog.get("Milk");
if (milk !== undefined) {
    console.log(milk.priceCents);
}
console.log(catalog.has("Rice"));
console.log(catalog.get("Rice"));

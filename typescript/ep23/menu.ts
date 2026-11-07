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
catalog.set("Rice", new Product("Rice", 199));
for (const entry of catalog) {
    const name = entry[0];
    const product = entry[1];
    console.log(name + ": " + product.priceCents);
}

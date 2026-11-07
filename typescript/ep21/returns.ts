class Product {
    name: string;
    priceCents: number;

    constructor(name: string, priceCents: number) {
        this.name = name;
        this.priceCents = priceCents;
    }
}

function removeByName(items: Product[], name: string): boolean {
    for (let i = 0; i < items.length; i++) {
        if (items[i].name === name) {
            items.splice(i, 1);
            return true;
        }
    }
    return false;
}

const first = new Product("Milk", 99);
const second = new Product("Milk", 99);
console.log(first === second);
const items: Product[] = [new Product("Bread", 150), first];
console.log(items.indexOf(second));
console.log(removeByName(items, "Milk"));
console.log(items.length);

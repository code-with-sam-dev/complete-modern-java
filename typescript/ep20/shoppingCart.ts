class Product {
    name: string;
    priceCents: number;

    constructor(name: string, priceCents: number) {
        this.name = name;
        this.priceCents = priceCents;
    }
}

class ShoppingCart {
    private items: Product[] = [];

    add(product: Product): void {
        this.items.push(product);
    }

    count(): number {
        return this.items.length;
    }

    totalCents(): number {
        let total = 0;
        for (const product of this.items) {
            total += product.priceCents;
        }
        return total;
    }
}

const cart = new ShoppingCart();
cart.add(new Product("Bread", 150));
cart.add(new Product("Milk", 99));
console.log(cart.count());
console.log(cart.totalCents());

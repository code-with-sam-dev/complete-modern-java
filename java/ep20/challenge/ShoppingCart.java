import java.util.ArrayList;

class ShoppingCart {
    private ArrayList<Product> items = new ArrayList<>();

    void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product cannot be null");
        }
        items.add(product);
    }

    int count() {
        return items.size();
    }

    int totalCents() {
        int total = 0;
        for (Product product : items) {
            total += product.getPriceCents();
        }
        return total;
    }
}

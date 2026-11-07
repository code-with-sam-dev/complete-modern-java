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

    boolean remove(Product product) {
        return items.remove(product);
    }

    boolean removeByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    void printNames() {
        for (Product product : items) {
            IO.println(product.getName());
        }
    }

    int totalCents() {
        int total = 0;
        for (Product product : items) {
            total += product.getPriceCents();
        }
        return total;
    }
}
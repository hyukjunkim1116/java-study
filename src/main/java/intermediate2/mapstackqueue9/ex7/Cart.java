package intermediate2.mapstackqueue9.ex7;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> cart = new HashMap<>();

    public void add(Product product, int amount) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + amount);
        } else {
            cart.put(product, amount);
        }
    }
    public void minus(Product product, int amount) {
        if (cart.get(product) <= amount) {
            cart.remove(product);
        } else {
            cart.put(product,cart.get(product) - amount);
        }
    }
    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> productIntegerEntry : cart.entrySet()) {
            System.out.println("상품: "+productIntegerEntry.getKey()+" 수량: "+productIntegerEntry.getValue());
        }
    }
}

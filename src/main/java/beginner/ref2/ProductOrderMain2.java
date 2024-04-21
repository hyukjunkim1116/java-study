package beginner.ref2;

import static beginner.ref2.ProductOrder.*;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        ProductOrder[] productOrders = new ProductOrder[3];
        ProductOrder tofu = createOrder("두부", 2000, 2);
        productOrders[0] = tofu;
        ProductOrder kimchi = createOrder("김치", 5000, 1);
        productOrders[1] = kimchi;
        ProductOrder coke = createOrder("콜라", 1500, 2);
        productOrders[2] = coke;
        printOrders(productOrders);
        int totalPrice= getTotalAmount(productOrders);
        System.out.println("총 결제 금액: "+totalPrice);
    }
}

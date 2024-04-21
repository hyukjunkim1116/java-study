package beginner.ref2;

public class ProductOrder {
    String productName;
    // 멤버변수(클래스에 있는 변수)는 자동초기화
    int price;
    int quantity;
    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName=productName;
        productOrder.price=price;
        productOrder.quantity=quantity;
        return productOrder;
    }
    static void printOrders(ProductOrder[] orders) {
        for (var order : orders) {
            System.out.println("상품명: "+order.productName+ ", 가격: "+order.price+ ", 수량: "+order.quantity);
        }
    }
    static int getTotalAmount(ProductOrder[] orders) {
        // 지역변수라서 초기화 해줘야함
        int totalPrice=0;
        for (var order : orders) {
            totalPrice += order.price*order.quantity;
        }
        return totalPrice;
    }
}

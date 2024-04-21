package beginner.ref2;

import java.util.Scanner;

import static beginner.ref2.ProductOrder.*;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int orderCount = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] productOrders = new ProductOrder[orderCount];
        for (int i = 1; i <= orderCount; i++) {
            System.out.println(i+"번째 주문 정보를 입력하세요.");
            System.out.print("상품명: ");
            String productName = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            productOrders[i-1]=createOrder(productName,price,quantity);
        }
        printOrders(productOrders);
        int totalPrice= getTotalAmount(productOrders);
        System.out.println("총 결제 금액: "+totalPrice);
    }
}

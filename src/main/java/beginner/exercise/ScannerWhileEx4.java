package beginner.exercise;

import java.util.Scanner;

public class ScannerWhileEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = 0;
        while (true) {
            System.out.println("1: 상품 입력, 2: 결제, 3: 프로그램 종료");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("상품명을 입력하세요: ");
                String productName = scanner.nextLine();
                System.out.println("상품의 가격을 입력하세요: ");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.println("구매 수량을 입력하세요: ");
                int amount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("상품명:"+productName+" 가격:"+price+" 수량:"+amount+" 합계:"+ price*amount);
                totalPrice += price*amount;
            } else if (option == 2) {
                System.out.println("총 비용:"+ totalPrice);
                totalPrice = 0;
            } else if (option == 3) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("올바른 옵션을 적어주세용");
            }
        }
    }
}

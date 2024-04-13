package starter.method;

import java.util.Scanner;

public class MethodEx4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int balance =0;
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("입금액을 입력하세요: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    balance = deposit(amount, balance);
                    break;
                case 2:
                    System.out.print("출금액을 입력하세요: ");
                    int withdraw = scanner.nextInt();
                    scanner.nextLine();
                    balance=withdraw(withdraw,balance);
                    break;
                case 3:
                    System.out.println("현재 잔액: "+balance);
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    return;
            }
        }
    }

    public static int withdraw(int withdraw,int balance) {
        if (balance < withdraw) {
            System.out.println(withdraw+"원을 출금하려 했으나 잔액이 부족합니다.");
            return balance;
        }
        balance-=withdraw;
        System.out.println(withdraw+"원을 출금하였습니다. 현재 잔액: "+balance);
        return balance;
    }
    public static int deposit(int amount,int balance) {
        balance+=amount;
        System.out.println(amount+"원을 입금하였습니다. 현재 잔액: "+balance);
        return balance;
    }
}

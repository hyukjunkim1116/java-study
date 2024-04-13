package beginner.exercise;

import java.util.Scanner;

public class ScannerEx5 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int startInd = scanner.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int endInd = scanner.nextInt();
        if (startInd > endInd) {
            int temp;
            temp = endInd;
            endInd = startInd;
            startInd = temp;
        }
        System.out.print("두 숫자 사이의 모든 정수:");
        for (int i = startInd; i <= endInd; i++) {
            if (i == endInd - 1) {
                System.out.print(i);
            } else {
                System.out.print(i+",");
            }
        }
    }
}

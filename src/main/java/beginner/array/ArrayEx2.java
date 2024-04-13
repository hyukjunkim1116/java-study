package beginner.array;

import java.util.Scanner;

public class ArrayEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("5개의 정수를 입력하세요:");
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int number : numbers) {
            if (number == numbers[4]) {
                System.out.print(number);
            } else {
                System.out.print(number+", ");
            }
        }
    }
}

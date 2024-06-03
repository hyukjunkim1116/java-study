package intermediate2.list5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx3 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        int total = 0;

        while (true) {
            int listElement = scanner.nextInt();
            if (listElement == 0) {
                break;
            }
            intList.add(listElement);
            total += listElement;

        }
        System.out.printf("입력한 정수의 합계 : %s%n",total);
        System.out.printf("입력한 정수의 평균 : %s%n",(double)total/intList.size());
    }
}

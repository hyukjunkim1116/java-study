package intermediate2.list5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int listElement = scanner.nextInt();
            if (listElement == 0) {
                break;
            } else {
                intList.add(listElement);
            }
        }
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i));
            if (i != intList.size()-1) {
                System.out.print(", ");
            }
        }
    }
}

package intermediate2.set8;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class UniqueNameTest3 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10}; // 코드 작성
        TreeSet<Integer> inputTreeSet = new TreeSet<>(List.of(inputArr));
        for (Integer i : inputTreeSet) {
            System.out.println(i);

        }
    }
}

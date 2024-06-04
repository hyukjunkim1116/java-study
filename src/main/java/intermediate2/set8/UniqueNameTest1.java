package intermediate2.set8;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueNameTest1 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10}; // 코드 작성
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (Integer i : inputArr) {
            hashSet.add(i);
        }
        for (Integer i : hashSet) {
            System.out.println(i);
        }

    }
}

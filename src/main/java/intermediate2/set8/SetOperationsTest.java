package intermediate2.set8;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));
//        Set<Integer> union = new HashSet<>();
//        union.addAll(set1);
//        union.addAll(set2);
//        System.out.println("합집합: "+union);
//        Set<Integer> intersect = new HashSet<>();
//        for (Integer i : set2) {
//            if (set1.contains(i)) {
//                intersect.add(i);
//            }
//        }
//        System.out.println("교집합: "+intersect);
//        Set<Integer> except = new HashSet<>(List.of(1, 2, 3, 4, 5));
//        for (Integer i : set2) {
//            if (set1.contains(i)) {
//                except.remove(i);
//            }
//        }
//        System.out.println("차집합: "+except);
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);

        Set<Integer> diff = new HashSet<>(set1);
        diff.removeAll(set2);
    }
}

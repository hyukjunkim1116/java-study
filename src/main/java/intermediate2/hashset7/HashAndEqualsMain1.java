package intermediate2.hashset7;

import java.util.HashSet;
import java.util.Set;

public class HashAndEqualsMain1 {
    public static void main(String[] args) {
        Set<MemberNoHashNoEq> set = new HashSet<>(10);
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));
        set.add(m1);
        set.add(m2);
        System.out.println(set);

        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A"); System.out.println("searchValue.hashCode() = " +
                searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);
    }
}

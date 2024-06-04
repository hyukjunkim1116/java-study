package intermediate2.mapstackqueue9;

import java.util.*;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"},
                {"Spring", "20000"},
                {"JPA", "30000"}};
        Map<String,Integer> map = new HashMap<>();
        for (String[] product : productArr) {
            List<String> productList = new ArrayList<>(List.of(product));
            map.put(productList.getFirst(), Integer.valueOf(productList.getLast()));
        }
        for (String s : map.keySet()) {
            System.out.println("제품: "+ s +", 가격: "+map.get(String.valueOf(s)));
        }
    }
}

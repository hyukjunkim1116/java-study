package intermediate2.mapstackqueue9;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple"; // 코드 작성
        Map<String,Integer> map = new HashMap<>();
        for (String s : text.split(" ")) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        System.out.println(map);
    }
}

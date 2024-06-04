package intermediate2.mapstackqueue9.ex6;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    private Map<String, Member> memberMap = new HashMap<>();
    public void save(Member member) {
        memberMap.put(member.getId(),member);
    }
    public void remove(String id) {
        memberMap.remove(id);
    }
    public Member findById(String id) {
       return memberMap.get(id);
    }
    public Member findByName(String name) {
        for (Member value : memberMap.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }
}

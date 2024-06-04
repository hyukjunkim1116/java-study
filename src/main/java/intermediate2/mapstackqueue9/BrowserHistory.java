package intermediate2.mapstackqueue9;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private Deque<String> history = new ArrayDeque<>();

    public void visitPage(String site) {
        history.push(site);
        System.out.println("방문 : "+site);
    }
    public String goBack() {
        String pop = history.pop();
        System.out.println("뒤로 가기: "+history.peek());
        return history.peek();
    }
}

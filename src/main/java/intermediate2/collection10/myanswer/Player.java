package intermediate2.collection10.myanswer;

import java.util.Set;
import java.util.TreeSet;

public class Player {
    private Set<Card> cardSet = new TreeSet<>(new CardComparator());
    public int getSum() {
        int sum = 0;
        for (Card card : cardSet) {
            sum += card.getNumber();
        }
        return sum;
    }

    public Set<Card> getCardList() {
        return cardSet;
    }

    @Override
    public String toString() {
        return "플레이어1의 카드: " + cardSet;
    }
}

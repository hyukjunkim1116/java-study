package intermediate2.collection10.myanswer;
import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card, Card t1) {
        if (!card.getNumber().equals(t1.getNumber())) {
            return card.getNumber().compareTo(t1.getNumber());
        } else {
            System.out.println(card.getShape());
            System.out.println(t1.getShape());
            return card.getShape().compareTo(t1.getShape());
        }
    }
}

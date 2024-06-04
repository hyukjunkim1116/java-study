package intermediate2.collection10.bestpractice;

public class Card implements Comparable<Card>{
    private final int rank;
    private final Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card anotherCard) {
        // enum 적은 순서대로 정렬됨.
        if (this.rank != anotherCard.rank) {
            return Integer.compare(this.rank, anotherCard.rank);
        } else {
            return this.suit.compareTo(anotherCard.suit);
        }
    }
    @Override
    public String toString() {
        return rank + "(" + suit.getIcon() + ")";
    }
}

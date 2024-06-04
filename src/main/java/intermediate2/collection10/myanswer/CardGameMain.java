package intermediate2.collection10.myanswer;

import java.util.*;

public class CardGameMain {
    public static void main(String[] args) {
        Deque<Card> deck = getShuffledDeck();
        Player player1 = new Player();
        Player player2 = new Player();
        distributeCard(player1,player2,deck);
        start(player1,player2);
    }

    public static void distributeCard(Player player1,Player player2, Deque<Card> deck) {
        for (int i = 0; i < 5; i++) {
            player1.getCardList().add(deck.pop());
            player2.getCardList().add(deck.pop());
        }
    }
    public static Deque<Card> getShuffledDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            deck.add(new Card("♠",i));
            deck.add(new Card("♥",i));
            deck.add(new Card("♦",i));
            deck.add(new Card("♣",i));
        }
        Collections.shuffle(deck);
        return new ArrayDeque<>(deck);
    }

    public static void start(Player player1, Player player2) {
        System.out.println("플레이어1의 카드: "+player1+", 합계: "+player1.getSum());
        System.out.println("플레이어2의 카드: "+player2+", 합계: "+player2.getSum());
        if (player1.getSum() > player2.getSum()) {
            System.out.println("플레이어1의 승리");
        } else if (player1.getSum() == player2.getSum()) {
            System.out.println("무승부");
        } else {
            System.out.println("플레이어2의 승리");
        }
    }
}

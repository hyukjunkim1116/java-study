package intermediate2.list5;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public ArrayList<Item> itemList = new ArrayList<>();
    public void addItem(Item item) {
        itemList.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        int total = 0;
        for (Item item : itemList) {
            System.out.println("상품명: "+item.getName()+", 합계: "+item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("전체 가격 합: "+total);
    }
}

package beginner.extend9;
public class Item {
    String name;
    int price;
    public Item(String name,int price) {
        this.name = name;
        this.price=price;
    }
    int getPrice() {
        return price;
    }
     void print() {
        System.out.println("이름: "+name+", 가격: "+price);
    }
}

package beginner.extend9;
public class Album extends Item{
    private final String album;

    Album(String name,int price,String album) {
        super(name, price);
        super.price=price;
        this.album=album;
    }
    @Override
    void print() {
        super.print();
        System.out.println("- 아티스트:"+album);
    }
}

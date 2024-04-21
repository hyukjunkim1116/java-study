package beginner.extend9;
public class Book extends Item{
    private final String author;
    private final String isbn;

    Book(String name,int price,String author,String isbn) {
        super(name, price);
        this.author=author;
        this.isbn=isbn;
    }

    @Override
    void print() {
        super.print();
        System.out.println("- 저자:"+author+", isbn:"+isbn);
    }
}

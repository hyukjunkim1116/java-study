package beginner.extend9;

public class Movie extends Item{
   private final String director;
    private final String actor;

    Movie(String name,int price,String director,String actor) {
        super(name,price);
        super.price=price;
        this.director=director;
        this.actor=actor;
    }
    @Override
    void print() {
        super.print();
        System.out.println("- 감독:"+director+", 배우:"+actor);
    }
}

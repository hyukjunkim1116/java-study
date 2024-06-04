package intermediate2.collection10.myanswer;

public class Card{
    public String getShape() {
        return shape;
    }

    private String shape;
    private Integer number;

    public Card(String shape, Integer number) {
        this.shape = shape;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "(" + shape + ")";
    }

}

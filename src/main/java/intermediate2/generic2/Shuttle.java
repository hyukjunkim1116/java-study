package intermediate2.generic2;

public class Shuttle<T extends BioUnit> {
    public T info;
    public void in(T unit) {
        info = unit;
    }
    public void showInfo() {
        System.out.println(info);
    }
}

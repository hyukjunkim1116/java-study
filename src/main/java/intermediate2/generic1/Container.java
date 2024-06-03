package intermediate2.generic1;

public class Container<T> {
    public T item;
    public Boolean isEmpty() {
        return item == null;
    }
    public void setItem(T item) {
        this.item=item;
    }

    public T getItem() {
        return item;
    }
}

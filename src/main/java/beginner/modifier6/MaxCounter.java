package beginner.modifier6;

public class MaxCounter {
    private int count;
    private final int max;
    MaxCounter(int max) {
        this.max = max;
    }
    void increment() {
        if (count == max) {
            System.out.println("최대값을 초과할 수 없습니다");
            return;
        }
        count += 1;
    }
    int getCount() {
        return count;
    }
}

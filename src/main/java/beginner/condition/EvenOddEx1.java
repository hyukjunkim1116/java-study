package beginner.condition;

public class EvenOddEx1 {
    public static void main(String[] args) {
        int x =10;
        String result = x % 2 == 0 ? "짝수" : "홀수";
        switch (result) {
            case "짝수" -> System.out.println("even");
            case "홀수" -> System.out.println("odd");
            default -> System.out.println("asd");
        }
    }
}

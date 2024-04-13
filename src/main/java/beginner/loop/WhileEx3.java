package beginner.loop;

public class WhileEx3 {
    public static void main(String[] args) {
//        for (int i = 1,max=100,sum=0; i <=max ; i++) {
//            sum+=i;
//            if (i == max) {
//                System.out.println(sum);
//            }
//        }
        int i = 1;
        int max = 100;
        int sum = 0;
        while (i<=max) {
            sum +=i;
            i++;
        }
        System.out.println(sum);
    }
}

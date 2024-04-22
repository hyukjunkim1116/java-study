package Intermediate1.wrapper4;

public class WrapperTest1 {
    public static void main(String[] args) {
        String str = "100"; // 오토 박싱
        Integer integer =Integer.valueOf(str);
        System.out.println(integer);
        int inteee = integer; //오토 언박싱
        System.out.println(inteee);
        Integer reInteger = inteee; // 오토 박싱
        System.out.println(reInteger);
    }
}

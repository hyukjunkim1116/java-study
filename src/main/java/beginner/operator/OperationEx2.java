package beginner.operator;

public class OperationEx2 {
    public static void main(String[] args) {
        double val1 =1.5;
        double val2 =2.5;
        double val3 =3.5;
        double sum = val1+val2+val3;
        double average = sum / 3; // 소수점 이하는 버림
        System.out.println("합"+sum+"평균"+average);
    }
}

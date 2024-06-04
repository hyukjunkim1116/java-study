package Intermediate1.enum5.ex1;

public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] values = AuthGrade.values();
        for (AuthGrade value : values) {
            System.out.println(value);
        }
        System.out.println(AuthGrade.LOGIN);
        System.out.println(AuthGrade.ADMIN);
    }
}

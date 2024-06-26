package Intermediate1.enum5;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        AuthGrade grade = AuthGrade.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("당신의 등급은 "+grade.getDescription()+"입니다");
        System.out.println("==메뉴 목록==");
        System.out.println("- 메인 화면");
        if (grade.equals(AuthGrade.LOGIN) || grade.equals(AuthGrade.ADMIN)) {
            System.out.println("- 이메일 관리 화면");
        }
        if (grade.equals(AuthGrade.ADMIN)) {
            System.out.println("- 관리자 화면");
        }
    }
}

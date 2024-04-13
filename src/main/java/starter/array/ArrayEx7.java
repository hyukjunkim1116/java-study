package starter.array;

import java.util.Scanner;

public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생수를 입력하세요: ");
        int studentNumbers = scanner.nextInt();
        scanner.nextLine();
        int[][] studentsScore = new int[studentNumbers][3];
        for (int i = 0; i < studentNumbers; i++) {
            System.out.println((i+1)+"번 학생의 성적을 입력하세요:");
            for (int j = 0; j < 3; j++) {
                if (j==0) {
                    System.out.print("국어 점수: ");
                } else if (j == 1) {
                    System.out.print("영어 점수: ");
                } else {
                    System.out.print("수학 점수: ");
                }
                studentsScore[i][j]=scanner.nextInt();
                scanner.nextLine();
            }
        }
        for (int i = 0; i < studentNumbers; i++) {
            int totalScore =0;
            for (int j = 0; j < 3; j++) {
                totalScore+=studentsScore[i][j];
            }
            System.out.println((i+1)+"번 학생의 총점: "+totalScore+", 평균: " +((double)totalScore/3));
        }
    }
}

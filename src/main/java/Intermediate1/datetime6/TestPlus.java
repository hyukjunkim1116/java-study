package Intermediate1.datetime6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestPlus {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 1, 0, 0);
//        System.out.println("기준시각: "+localDateTime);
//        LocalDateTime futureDateTime =localDateTime.plusYears(1).plusMonths(2).plusDays(3).plusHours(4);
//        System.out.println("1년 2개월 3일 4시간 후의 시각: " + futureDateTime);
//        LocalDate localDate = LocalDate.of(2024, 1, 1);
//        for (int i = 1; i < 6; i++) {
//            DateTimeFormatter a = DateTimeFormatter.ofPattern("YYYY-MM-dd");
//            System.out.println("날짜 "+i+": "+ localDate.plusWeeks(2*(i-1)));
//        }
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);
        Period period = Period.between(startDate, endDate);

    }
}

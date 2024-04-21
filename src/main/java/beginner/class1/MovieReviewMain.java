package beginner.class1;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview incept = new MovieReview();
        incept.review = "인생은 무한 루프";
        incept.title = "인셉션";
        MovieReview aboutTIme = new MovieReview();
        aboutTIme.title = "어바웃타임";
        aboutTIme.review = "인생 시간 용화!";
        System.out.println("영화 제목 : "+incept.title+", 리뷰: "+incept.review );
        System.out.println("영화 제목 : "+aboutTIme.title+", 리뷰: "+aboutTIme.review );
    }
}

package beginner.class1;

public class MovieReviewMain2 {
    public static void main(String[] args) {
        // 무비리뷰 타입 객체를 넣을 수 있는 배열 2개 생성
        MovieReview[] movies = new MovieReview[2];
        // 무비리뷰 생성 먼저 하고 값 원하는거 넣고 배열에 넣어야 맞음
        MovieReview i = new MovieReview();
        MovieReview a = new MovieReview();
        i.review = "인생은 무한 루프";
        i.title = "인셉션";
        a.review = "인생 시간 용화!";
        a.title = "어바웃타임";
        movies[0] = i;
        movies[1] = a;
        for (var movie : movies) {
            System.out.println("영화 제목 : "+movie.title+", 리뷰: "+movie.review );
        }
    }
}

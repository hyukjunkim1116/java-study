package Intermediate1.wrapper4;

public class LottoMain {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        int[] lottoNumbers = generator.generate();
        System.out.println("로또 번호: ");
        for (int lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber + " ");
        }

    }
}

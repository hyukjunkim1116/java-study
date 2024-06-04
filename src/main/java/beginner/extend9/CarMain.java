package beginner.extend9;

public class CarMain {
    public static void main(String[] args) {
        GasCar car = (GasCar) new Car();
        //오류 생김
        car.fillUp();

    }
}

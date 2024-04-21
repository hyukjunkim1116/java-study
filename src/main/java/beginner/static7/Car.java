package beginner.static7;

class Car {
    private String name;
    static int totalCars;

    Car(String name) {
        System.out.println("차량 구입, 이름: "+name);
        this.name=name;
        totalCars++;
    }

    static void showTotalCars() {
        System.out.println("구매한 차량 수: "+totalCars);
    }
}

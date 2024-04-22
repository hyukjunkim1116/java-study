package Intermediate1.inner8;

public class OuterClass1Main {
    public static void main(String[] args) {
//        OuterClass1 outerClass1 = new OuterClass1();
//        outerClass1.new NestedClass().hello();
        OuterClass1.NestedClass outerClass1 = new OuterClass1.NestedClass();
        outerClass1.hello();
    }
}

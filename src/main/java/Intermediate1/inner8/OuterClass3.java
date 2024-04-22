package Intermediate1.inner8;

public class OuterClass3 {
    public void myMethod() {
        class LocalClass {
             private void hello() {
                System.out.println("LocalClass.hello");
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.hello();
    }
}

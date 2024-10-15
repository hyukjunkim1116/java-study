package advanced2.io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/inputoutput2/temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/inputoutput2/temp/hello.dat");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.println(data);
        }
        fis.close();

    }
}

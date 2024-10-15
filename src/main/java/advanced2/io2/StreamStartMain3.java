package advanced2.io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/inputoutput2/temp/hello.dat");
        byte[] input = {65, 66, 67};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/inputoutput2/temp/hello.dat");
        byte[] buffer = new byte[10];
        int readCount = fis.read(buffer, 0, 10);
        System.out.println("readCount = " + readCount);
        System.out.println(Arrays.toString(buffer));

        fis.close();

    }
}

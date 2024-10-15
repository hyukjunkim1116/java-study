package advanced2.file5.temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV2 {


    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/file5/temp/hello.txt");
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/file5/temp/hello2.txt");
        fis.transferTo(fos);
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }
}

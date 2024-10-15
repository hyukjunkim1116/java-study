package advanced2.inputoutput3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static advanced2.inputoutput3.TextConst.FILE_NAME;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        byte[] writeBytes = writeString.getBytes(StandardCharsets.UTF_8);
        System.out.println("write String: "+writeString);
        System.out.println("write bytes: "+ Arrays.toString(writeBytes));

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        String readString = new String(readBytes, StandardCharsets.UTF_8);
        System.out.println("read bytes: " + Arrays.toString(writeBytes));
        System.out.println("read String: "+ readString);
    }
}

package advanced2.io3;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static advanced2.io3.TextConst.FILE_NAME;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("write String: " + writeString);

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        osw.write(writeString);
        osw.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = isr.read()) != -1) {
            content.append((char) ch);
        }
        isr.close();

        System.out.println("read String: " + content);
    }
}

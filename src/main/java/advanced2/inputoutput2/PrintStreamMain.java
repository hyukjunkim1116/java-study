package advanced2.inputoutput2;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;
        byte[] bytes = "Hello!\n".getBytes(StandardCharsets.UTF_8);
        ps.write(bytes);
        ps.println("Print!");

    }
}

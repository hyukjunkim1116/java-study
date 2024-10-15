package advanced2.file5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV1 {

    private static final String PATH = "src/main/java/advanced2/file5/temp/hello.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다"; System.out.println("== Write String =="); System.out.println(writeString);
        Path path = Path.of(PATH);

        Files.writeString(path, writeString, UTF_8);

        String readString = Files.readString(path, UTF_8);

        System.out.println("== Read String ==");
        System.out.println(readString);

        List<String> lines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }

        try(Stream<String> lineStream = Files.lines(path, UTF_8)){
            lineStream.forEach(System.out::println);
        }
    }
}

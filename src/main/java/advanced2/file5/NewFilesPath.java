package advanced2.file5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class NewFilesPath {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path: " + path);
        System.out.println("Absolute path: " + path.toAbsolutePath());
        System.out.println("Canonical path: " + path.toRealPath());
        Stream<Path> pathStream = Files.list(path);
        List<Path> list = pathStream.toList();
        pathStream.close();

        for (Path p : list) {
            System.out.println((Files.isRegularFile(p) ? "File: " : "Directory: ") + " | " + p.getFileName());
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExercise {
    public static void m1() {
        Path path = Path.of("C:/Priyanshu/Java learning/testproject/src/main/java/FileExercise.java");
        System.out.println(path.getFileName());
        Path p2 = Paths.get("C:/Priyanshu/Java learning/testproject/src/main/java/FileExercise.java");

        try (BufferedReader reader = Files.newBufferedReader(p2, StandardCharsets.ISO_8859_1);) {
            String s = reader.readLine();
            while (s != null) {
                System.out.println(s);
                s = reader.readLine();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static void writeFile() {

        Path f = Paths.get("C:/Priyanshu/Java learning/testproject/src/main/resources/debug.log");
        try (BufferedWriter writer = Files.newBufferedWriter(f);) {
            Path path = Path.of("C:/Priyanshu/Java learning/testproject/src/main/java/FileExercise.java");
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line = reader.readLine();
                do {
                    writer.write(line + "\n");
                    line = reader.readLine();
                } while (line != null);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

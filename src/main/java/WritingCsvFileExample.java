import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.stream.Stream;

public class WritingCsvFileExample {

    public static void readCsvFIle() {
        Path p = Paths.get("C:/Users/paratpri/Desktop/test.csv");
        try (Stream<String> reader = Files.lines(p);) {
            reader.skip(1).flatMap(x -> Arrays.asList(x.split(";")).stream()).map(x -> x.toUpperCase())
                    .forEach(x -> System.out.println(x));

        } catch (IOException exception) {

        }
    }

    public static void codeCounter2() {

        Path p = Paths.get("C:/Product/Trunk");
        try {

            Files.walk(p).parallel().filter(x -> !Files.isDirectory(x)).map(x -> x.getFileName())
                    .forEach(x -> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void codeCounter() {

        Path p = Paths.get("C:/Product/Trunk");

        FileVisitor<Path> visitor = new FileVisitor<Path>() {
            public long fileCount = 0;
            public long totalCodeLines = 0;

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                boolean isCode = false;
                if (isCode) {
                    fileCount++;
                    try {
                        totalCodeLines += Files.lines(file).count();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

        };
        try {

            Files.walkFileTree(p, visitor);
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
        String fileCount;
        try {
            fileCount = visitor.getClass().getField("fileCount").get(visitor).toString();
            String totalCodeLines = visitor.getClass().getField("totalCodeLines").get(visitor).toString();
            System.out.println("total number of c£ file: " + fileCount);
            System.out.println("total number of lines: " + totalCodeLines);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

    }
}

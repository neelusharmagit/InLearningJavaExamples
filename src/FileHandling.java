import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandling {


    public static void main(String[] args) {

        String dirLocation = "/Users/neesharm7/InLearningActivities/files";

        // List files and subdirin a dir
        listFileinDir(dirLocation);

        //list only files
        listOnlyFilesinDir(dirLocation);

        filterFileswithContent(dirLocation);
    }

    private static void listFileinDir(String dirLocation) {
        try {
            List<File> files = Files.list(Paths.get(dirLocation))
                    .parallel().map(Path::toFile)
                    .collect(Collectors.toList());

            files.forEach(System.out::println);
        } catch (IOException e) {
            // Error while reading the directory
        }
    }


    private static void listOnlyFilesinDir(String dirLocation) {
        try {
            List<File> files = Files.list(Paths.get(dirLocation))
                    .parallel().map(Path::toFile)
                    .filter(e -> e.isFile())
                    .collect(Collectors.toList());

            files.forEach(System.out::println);
        } catch (IOException e) {
            // Error while reading the directory
        }
    }


    private static void filterFileswithContent(String dirLocation) {
        try {
            List<File> files = Files.list(Paths.get(dirLocation))
                    .parallel().map(Path::toFile)
                    .filter(e -> e.isFile())
                    .filter(e -> hasText(e))
                    .collect(Collectors.toList());

            files.forEach(System.out::println);
        }
        catch (IOException e) {
            // Error while reading the directory
        }
    }



    private static boolean hasText(File f){
        boolean containsText = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f)) ;
            containsText = br.lines().filter(e -> e.contains("filter")).collect(Collectors.toList()).size() > 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return containsText;
    }
}

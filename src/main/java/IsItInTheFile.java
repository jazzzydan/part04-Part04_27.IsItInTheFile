
import java.nio.file.Paths;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file:");
        String file = scanner.nextLine();
        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();
        searchInFile(file, searchedFor);
    }

    public static void searchInFile(String fileName, String searchString) {
        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                String row = fileScanner.nextLine();
                if (row.contains(searchString)) {
                    System.out.println("Found!");
                    return;
                }
            }
            System.out.println("Not found.");
        } catch (Exception e) {
            System.out.println("Reading the file " + fileName + " failed.");
        }
    }
}

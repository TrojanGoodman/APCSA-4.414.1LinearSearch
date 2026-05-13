import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearchApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Mo's Popular Movie Search");

        File dataFile = new File("src/data.txt");
        if (!dataFile.exists()) {
            dataFile = new File("bin/data.txt");
        }

        if (!dataFile.exists()) {
            System.err.println("Error: data.txt file not found in src/ or bin/.");
            return;
        }

        List<String> items = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(dataFile)) {
            while (fileScanner.hasNextLine()) {
                items.add(fileScanner.nextLine());
            }
        }

        if (items.isEmpty()) {
            System.err.println("Error: data.txt is empty. Add some search data and try again.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a search term: ");
        String searchTerm = input.nextLine().trim();

        if (searchTerm.length() == 0) {
            System.out.println("No search term entered. Exiting.");
            return;
        }

        String lowerSearch = searchTerm.toLowerCase();
        int matchCount = 0;

        for (String item : items) {
            if (item.toLowerCase().indexOf(lowerSearch) != -1) {
                System.out.println(item);
                matchCount++;
            }
        }

        if (matchCount == 0) {
            System.out.println(searchTerm + " Not Found");
        } else {
            System.out.println("Found " + matchCount + " match" + (matchCount == 1 ? "" : "es") + ".");
        }
    }
}

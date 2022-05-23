import java.util.Scanner;

public class Navigation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int connections = scanner.nextInt();
            scanner.nextLine(); // Go to new line
            
            for (int j = 0; j < connections; j++) {
                scanner.nextLine();
            }

            int queries = scanner.nextInt();
            scanner.nextLine(); // Go to new line

            for (int j = 0; j < queries; j++) {
                scanner.nextLine();
                System.out.println("QUERY");
            }
        }
    }

}

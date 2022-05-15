import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Navigation {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String[] splitted = line.split(" => ");

            String a = splitted[0];
            String b = splitted[1];
            if (!graph.containsKey(a)) {
                ArrayList<String> list = new ArrayList<>();
                graph.put(a, list);
            }

            if (!graph.containsKey(b)) {
                ArrayList<String> list1 = new ArrayList<>();
                graph.put(b, list1);
            }

            graph.get(a).add(b);

            graph.get(b).add(a);

        }

        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine();
            String[] splitQuery = query.split(" => ");
            HashSet<String> visited = new HashSet<>();
            System.out.println(pathFinder(graph, splitQuery[0], splitQuery[1], visited));
        }
    }

    public static boolean pathFinder(HashMap<String, ArrayList<String>> g,
                                     String x,
                                     String y,
                                     HashSet<String> vis) {
        if (x.equalsIgnoreCase(y)) {
            return true;
        }

        if (vis.contains(x)) {
            return false;
        }

        vis.add(x);

        for (String s: g.get(x)) {
            if (pathFinder(g, s, y, vis)) {
                return true;
            }
        }

        return false;

    }
}

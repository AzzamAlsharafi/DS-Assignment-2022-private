//package Q2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Navigation {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/Q2/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 0; x < t; x++) {
            if(x > 0){
                throw new Exception("HELLO + nextLine? nextInt? next? what?");// + scanner.hasNextLine() + scanner.hasNextInt() + scanner.hasNext());
            }
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
                String[] splitQuery = query.split(" -> ");
                HashSet<String> visited = new HashSet<>();
                ArrayList<String> path = new ArrayList<>();

                if (pathFinder(graph, splitQuery[0], splitQuery[1], visited, path)) {
                    for (int j = 0; j < path.size(); j++) {
                        if (j == path.size() - 1) {
                            if (i == q - 1) {
                                System.out.print(path.get(j));

                            } else {
                                System.out.println(path.get(j));

                            }
                        } else {
                            System.out.print(path.get(j) + " -> ");
                        }
                    }
                }

            }
        }
    }

    public static boolean pathFinder(HashMap<String, ArrayList<String>> g,
            String x,
            String y,
            HashSet<String> vis, ArrayList<String> p) {

        if (x.equalsIgnoreCase(y)) {
            p.add(x);
            return true;
        }

        if (vis.contains(x)) {
            return false;
        }
        p.add(x);
        vis.add(x);

        for (String s : g.get(x)) {
            if (pathFinder(g, s, y, vis, p)) {
                return true;
            }
        }
        p.remove(p.size() - 1);
        return false;

    }
}

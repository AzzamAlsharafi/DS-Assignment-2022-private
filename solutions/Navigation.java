import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Navigation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int connections = scanner.nextInt();
            scanner.nextLine(); // Go to new line
            
            // Add cities and paths to graph
            for (int j = 0; j < connections; j++) {
                String[] line = scanner.nextLine().split(" => ");
                
                if(graph.containsKey(line[0])){
                    graph.get(line[0]).add(line[1]);
                } else {
                    ArrayList<String> newList = new ArrayList<>();
                    newList.add(line[1]);
                    graph.put(line[0], newList);
                }

                if(graph.containsKey(line[1])){
                    graph.get(line[1]).add(line[0]);
                } else {
                    ArrayList<String> newList = new ArrayList<>();
                    newList.add(line[0]);
                    graph.put(line[1], newList);
                }
            }

            int queries = scanner.nextInt();
            scanner.nextLine(); // Go to new line

            for (int j = 0; j < queries; j++) {
                String[] line = scanner.nextLine().split(" -> ");
                
                ArrayList<String> path = getPath(graph, line[0], line[1], new ArrayList<>());
                
                path.add("TEST");
                path.add("TEST?");

                if(path.size() > 0){
                    System.out.println(String.join(" -> ", path));
                }
            }
        }

        scanner.close();
    }

    public static ArrayList<String> getPath(HashMap<String, ArrayList<String>> graph, String src, String dest, ArrayList<String> path){
        return new ArrayList<>();
    }

}

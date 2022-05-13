import java.util.PriorityQueue;
import java.util.Scanner;

public class Payment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<txnId> queue = new PriorityQueue<>();

        String[] firstLine = scanner.nextLine().split(" ");
        long firstTime = Long.parseLong(firstLine[0]);

        long firstStartTime = firstTime - startingTimeFromTier(firstLine[2].charAt(0));

        queue.offer(new txnId(firstLine[1], firstStartTime));

        long previousTime = firstTime;

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");

            if (line.length == 3) {
                long time = Long.parseLong(line[0]);

                long startTime = time - startingTimeFromTier(line[2].charAt(0));

                queue.offer(new txnId(line[1], startTime));

                if ((time / 1000) - (previousTime / 1000) > 0) {
                    for (int i = 0; i < 100; i++) {
                        System.out.print(queue.poll() + " ");
                    }
                    System.out.println();
                }

                previousTime = time;
            } else {
                if (line[0].equals("EXIT")) {
                    return;
                } else {
                    queue.clear();
                }
            }
        }
    }

    public static long startingTimeFromTier(char firstChar) {
        switch (firstChar) {
            case 'B': // Bronze
                return 0;
            case 'S': // Silver
                return 1000;
            case 'G': // Gold
                return 2000;
            case 'P': // Platinum
                return 3000;
            default: // Won't happen.
                return -1;
        }
    }

}

class txnId implements Comparable<txnId> {
    String id;
    long time;

    public txnId(String id, long time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public int compareTo(txnId o) {
        return Long.compare(time, o.time);
    }

    @Override
    public String toString() {
        return id;
    }
}

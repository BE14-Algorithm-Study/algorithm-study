import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startLocation = Integer.parseInt(st.nextToken());
        int targetLocation = Integer.parseInt(st.nextToken());

        System.out.println(bfs(startLocation, targetLocation));
    }

    private static int bfs(int startLocation, int targetLocation) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.offer(startLocation);
        visited[startLocation] = true;
        int second = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curLocation = queue.poll();

                if (curLocation == targetLocation) {
                    return second;
                }

                int[] nextLocations = {curLocation * 2, curLocation + 1, curLocation - 1};

                for (int next : nextLocations) {
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            second++;
        }
        return second;
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int nodeCases = Integer.parseInt(st.nextToken());
        int edgesCases = Integer.parseInt(st.nextToken());

        map = new int[nodeCases + 1][nodeCases + 1];
        visited = new boolean[nodeCases + 1];

        for (int i = 0; i < edgesCases; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            map[row][column] = 1;
            map[column][row] = 1;
        }

        for (int i = 1; i <= nodeCases; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

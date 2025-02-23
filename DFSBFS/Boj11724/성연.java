import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;

        st = new StringTokenizer(br.readLine());
        int nodeCases = Integer.parseInt(st.nextToken());
        int edgesCases = Integer.parseInt(st.nextToken());
        int[][] map = new int[nodeCases + 1][nodeCases + 1];
        boolean[] visited = new boolean[nodeCases + 1];

        for(int i = 0; i < edgesCases; i++) {
            st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            map[row][column] = 1;
            map[column][row] = 1;
        }

        for (int i = 1; i <= nodeCases; i++) {
            if (!visited[i]) {
                dfs(map, visited, i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int[][] map, boolean[] visited, int row) {
        Stack<Integer> stack = new Stack<>();
        stack.push(row);
        visited[row] = true;

        while(!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;

            for(int i = 1; i < map.length; i++) {
                if(map[current][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }
}

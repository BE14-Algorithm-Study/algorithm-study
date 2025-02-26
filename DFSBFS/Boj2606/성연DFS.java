import java.util.*;
import java.io.*;

public class Main {
    static int node;
    static int edge;
    static int[][] map;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        map = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            map[column][row] = 1;
            map[row][column] = 1;
        }


        dfs(1);

        System.out.println(count - 1);
    }

    public static void dfs(int start) {
        visit[start] = true;
        count++;

        for(int i = 1; i <= node; i++) {
            if(map[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}

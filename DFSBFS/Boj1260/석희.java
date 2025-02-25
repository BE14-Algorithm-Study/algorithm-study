package BOJ.Silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static int n, m, v;                 // 정점의 개수, 간선의 개수, 시작 정점
    static boolean[][] graph;           // 간선은 양방향
    static boolean[] visitDfs;
    static boolean[] visitBfs;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        dfs(v);
        sb.append("\n");

        // visit 배열 초기화             -> 184ms
        // DFS와 BFS 각각 다른 배열 사용   -> 176ms
//        Arrays.fill(visit, false);

        bfs(v);

        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new boolean[n + 1][n + 1];
        visitDfs = new boolean[n + 1];
        visitBfs = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = true;
            graph[end][start] = true;
        }
    }

    static void dfs(int node) {
        visitDfs[node] = true;
        sb.append(node).append(" ");

        for(int i = 1; i <= n; i++) {
            if(visitDfs[i] || !graph[node][i]) continue;
            dfs(i);
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visitBfs[node] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");

            for(int i = 1; i <= n; i++) {
                if(visitBfs[i] || !graph[x][i]) continue;
                visitBfs[i] = true;
                queue.add(i);
            }
        }
    }
}

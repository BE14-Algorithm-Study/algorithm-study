package BOJ.Silver.S3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int n;
    static int m;
    static boolean[][] graph;

    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        input();
        solve(1);

        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visit = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        visit[1] = true;
    }

    static void solve(int start) {
        visit[start] = true;

        for(int i = 1; i <= n; i++) {
            // 연결되어 있고, 방문하지 않았다면
            if (graph[start][i] && !visit[i]) {
                answer++;
                solve(i);
            }
        }
    }
}

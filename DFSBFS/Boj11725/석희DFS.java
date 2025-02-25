package BOJ.Silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {

    static int n;                                // 노드의 개수
//    static boolean[][] graph;                  // -> 메모리 초과 발생
    static ArrayList<Integer>[] graph;
    static int[] visit;                         // 방문 처리 + 부모 저장

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        visit = new int[n + 1];
        int n1, n2;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }
    }

    static void solve() {
        visit[1] = 1;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        for(int i : graph[node]) {
            if(visit[i] != 0) continue;

            // dfs가 먼저 호출된 node가 부모
            visit[i] = node;
            dfs(i);
        }
    }
}

package BOJ.Silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방문이 모두 끝났으면 연결되어 있는 노드들은 모두 visit=true일 것이다.
// 만약 false인 노드를 만났다면 그 전 노드와는 연결되어 있지 않다는 뜻 -> answer++
// 그 노드에 연결되어있는 노드들을 또 dfs로 찾아서 visit true로 만들어주기

public class BOJ_11724 {
    static int n, m;
    static boolean[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();
        sb.append(solve());
        System.out.println(sb);
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 방향 없는 그래프
            graph[u][v] = true;
            graph[v][u] = true;
        }
    }

    static void dfs(int node) {
        for(int i = 1; i <= n; i++) {
            if(!graph[node][i] || visit[i]) continue;
            visit[i] = true;
            dfs(i);
        }
    }

    static int solve() {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            answer++;
            dfs(i);
        }

        return answer;
    }
}

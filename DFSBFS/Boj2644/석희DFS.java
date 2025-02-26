import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, m;                // 전체 사람 수, 관계 수
    static int target1, target2;
    static boolean[][] graph;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        input();
        dfs(target1);

        StringBuilder sb = new StringBuilder();
        sb.append(visit[target2] == 0 ? -1 : visit[target2]);
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];
        visit = new int[n + 1];
         for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());

             graph[x][y] = true;
             graph[y][x] = true;
         }
    }

    static void dfs(int node) {
        if(node == target2) return;

        for (int i = 1; i <= n; i++) {
            if(!graph[node][i] || visit[i] != 0) continue;
            visit[i] = visit[node] + 1;
            dfs(i);
        }
    }
}

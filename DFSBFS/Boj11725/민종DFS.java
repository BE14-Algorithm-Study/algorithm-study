package S2.BOJ11725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS {
    static int N;                           // 노드의 개수
    static int[] parent;                    // 부모를 나타내는 배열
    static boolean[] visited;               // 방문 배열
    static List<Integer>[] connection;      // 각 노드들의 연결된 노드 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visited = new boolean[N+1];
        connection = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            connection[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connection[a].add(b);
            connection[b].add(a);
        }
        dfs(1);
        for(int i=2; i<=N; i++){
            bw.write(parent[i] + "\n");
        }
        bw.flush();
    }

    public static void dfs(int num){
        visited[num] = true;
        for(int i : connection[num]) {
            if (!visited[i]) {
                parent[i] = num;
                dfs(i);
            }
        }
    }
}

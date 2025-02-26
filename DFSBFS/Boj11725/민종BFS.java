package S2.BOJ11725;

import java.io.*;
import java.util.*;

public class BFS {

    static int N;                           // 노드
    static boolean[] visited;               // 방문 배열
    static int[] parent;                    // 부모 배열
    static List<Integer>[] connection;      // 연결된 노드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N+1];
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
        bfs(1);
        for(int i=2; i<=N; i++){
            bw.write(parent[i] + "\n");
        }
        bw.flush();
    }
    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : connection[now]){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = now;
                }
            }
        }
    }
}

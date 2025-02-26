package BOJ.Silver.S1;// 1 : 이동 가능, 0 : 이동 불가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[][] map;
    static int[][] visit;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(visit[N-1][M-1]);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String oneMap;
        map = new char[N][M];
        visit = new int[N][M];
        for(int i = 0; i < N; i++) {
            oneMap = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = oneMap.charAt(j);
            }
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visit[0][0] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == '0') continue;
                if(visit[nx][ny] != 0) continue;

                visit[nx][ny] = visit[node.x][node.y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }
    }
}

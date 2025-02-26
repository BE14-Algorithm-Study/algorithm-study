import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 0 배추 X, 1 배추 O

public class BOJ_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;           // 테스트 케이스 개수
    static int M, N, K;    // 가로, 세로, 배추 위치 개수

    static int[][] map;
    static boolean[][] visit;

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
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            sb.append(solve()).append("\n");
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        int x, y;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());       // 가로 (M)
            x = Integer.parseInt(st.nextToken());       // 세로 (N)
            map[x][y] = 1;
        }
    }

    static int solve() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visit[i][j]) continue;
                answer++;
                bfs(i, j);
            }
        }

        return answer;
    }

    static void bfs(int sx, int sy) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sx, sy));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                queue.offer(new Node(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }
}

package BOJ.Silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 땅 = 1, 바다 = 0

public class BOJ_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 대각선까지 포함이니까
    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    static int w = -1, h = -1;              // 지도의 너비, 높이
    static int[][] map;                     // 지도
    static boolean[][] visit;               // 방문 여부

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            // region w, h
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // endregion

            if(w == 0 && h == 0) break;

            input();
            // 끝나는 조건이 아니라면 탐색 시작
            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 방문하지 않았고 땅이라면
                    if (!visit[i][j] && map[i][j] == 1) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void input() throws IOException {
        map = new int[h][w];
        visit = new boolean[h][w];

        // region map
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // endregion
    }

    static void bfs(int sx, int sy) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sx, sy));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visit[nx][ny]) continue;

                // 바다라면 확인 X
                if (map[nx][ny] == 0) continue;

                queue.offer(new Node(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }
}

package BOJ.Silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1은 집 O, 0은 집 X
public class BOJ_2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;           // 지도의 크기
    static char[][] map;
    static int[][] visit;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static ArrayList<Integer> answer = new ArrayList<>();

    static class Node {
        int x, y;
        public Node(int x, int y) {this.x = x; this.y = y;}
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visit = new int[N][N];

        String oneLine;
        for(int i = 0; i < N; i++) {
            oneLine = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = oneLine.charAt(j);
            }
        }
    }

    static void solve() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j] != 0 || map[i][j] == '0') continue;
                answer.add(bfs(i, j));
            }
        }

        sb.append(answer.size()).append('\n');
        Collections.sort(answer);
        for(int ans : answer) {sb.append(ans).append('\n');}
//        answer.stream().sorted().forEach(a -> sb.append(a).append('\n'));
        System.out.println(sb);
    }

    static int bfs(int sx, int sy) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy));
        visit[sx][sy] = 1;
        int count = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x, y = node.y;

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[nx][ny] == '0') continue;
                if(visit[nx][ny] != 0) continue;

                visit[nx][ny] = visit[x][y] + 1;
                queue.add(new Node(nx, ny));
                count++;
            }
        }

        return count;
    }
}

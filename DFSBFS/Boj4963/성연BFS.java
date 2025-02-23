import java.util.*;
import java.io.*;

public class Main {
    static int[] moveX = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] moveY = {1, 1, 1, 0, -1, -1, -1, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            count = 0;

            if (column == 0 && row == 0) {
                break;
            }

            int[][] map = new int[column][row];
            boolean[][] visited = new boolean[column][row];
            for (int i = 0; i < column; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < row; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(i, j, map, visited);
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int row, int column, int[][] map, boolean[][] visited) { // 수정
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, column));
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 8; i++) {
                int curX = node.column + moveX[i];
                int curY = node.row + moveY[i];

                if (checkBoundary(curY, curX, map) && map[curY][curX] == 1 && !visited[curY][curX]) {
                    queue.offer(new Node(curY, curX));
                    visited[curY][curX] = true;
                }
            }
        }
    }

    private static boolean checkBoundary(int row, int column, int[][] map) { // 수정
        return row >= 0 && row < map.length && column >= 0 && column < map[0].length;
    }

    public static class Node {
        int row;
        int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] chessBoard;
    static boolean[][] visited;
    static int[] knightMoveX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] knightMoveY = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int boardSize = Integer.parseInt(br.readLine());
            chessBoard = new int[boardSize][boardSize];
            visited = new boolean[boardSize][boardSize];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            if (startX == targetX && startY == targetY) {
                sb.append(0).append("\n");
            } else {
                sb.append(bfs(startX, startY, targetX, targetY, boardSize)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int startX, int startY, int targetX, int targetY, int boardSize) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == targetX && current.y == targetY) {
                return current.count;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + knightMoveX[i];
                int nextY = current.y + knightMoveY[i];

                if (isValid(nextX, nextY, boardSize) && !visited[nextY][nextX]) {
                    queue.offer(new Node(nextX, nextY, current.count + 1));
                    visited[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int boardSize) {
        return x >= 0 && x < boardSize && y >= 0 && y < boardSize;
    }

    public static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

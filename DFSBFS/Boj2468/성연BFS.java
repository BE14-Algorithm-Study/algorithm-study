import java.util.*;
import java.io.*;

public class Main {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] floodInfo;
    static int mapSize;
    static int maxHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];

        maxHeight = 1;
        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSafeZones = 1;
        for (int height = 0; height <= maxHeight; height++) {
            floodInfo = new boolean[mapSize][mapSize];
            visited = new boolean[mapSize][mapSize];


            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (map[i][j] <= height) {
                        floodInfo[i][j] = true;
                    }
                }
            }

            int safeZoneCount = 0;
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (!floodInfo[i][j] && !visited[i][j]) {
                        bfs(j, i);
                        safeZoneCount++;
                    }
                }
            }
            maxSafeZones = Math.max(maxSafeZones, safeZoneCount);
        }

        System.out.println(maxSafeZones);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int curX = node.x + moveX[i];
                int curY = node.y + moveY[i];

                if (isValid(curX, curY) && !floodInfo[curY][curX] && !visited[curY][curX]) {
                    queue.offer(new Node(curX, curY));
                    visited[curY][curX] = true;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < mapSize && y >= 0 && y < mapSize;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

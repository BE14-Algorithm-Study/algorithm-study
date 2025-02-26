import java.util.*;
import java.io.*;

public class Main {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int[][] tomatoStorage;
    static int rowCases;
    static int columnCases;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        columnCases = Integer.parseInt(st.nextToken());
        rowCases = Integer.parseInt(st.nextToken());
        tomatoStorage = new int[rowCases][columnCases];

        for (int i = 0; i < rowCases; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columnCases; j++) {
                tomatoStorage[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoStorage[i][j] == 1) {
                    queue.offer(new Node(j, i, 0));
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            maxDays = Math.max(maxDays, node.days);

            for (int i = 0; i < 4; i++) {
                int curX = node.x + moveX[i];
                int curY = node.y + moveY[i];

                if (isValid(curX, curY) && tomatoStorage[curY][curX] == 0) {
                    tomatoStorage[curY][curX] = 1;
                    queue.offer(new Node(curX, curY, node.days + 1));
                }
            }
        }

        if (isRiped()) {
            return -1;
        }
        return maxDays;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < columnCases && y >= 0 && y < rowCases;
    }

    public static boolean isRiped() {
        for (int i = 0; i < rowCases; i++) {
            for (int j = 0; j < columnCases; j++) {
                if (tomatoStorage[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class Node {
        
        int x, y, days;

        public Node(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
}

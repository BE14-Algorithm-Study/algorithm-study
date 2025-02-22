import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int worms = 0;
    static Stack<Node> stack;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int curX;
    static int curY;

    public static void main(String[] args) throws IOException    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());

        for(int k = 0; k < testCases; k++) {
            worms = 0;

            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int cabbageCount = Integer.parseInt(st.nextToken());

            map = new int[column][row];
            visit = new boolean[column][row];
            stack = new Stack<>();

            for (int i = 0; i < cabbageCount; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        /*ToDo. stack.push와 visit 방문 초기화, stack 생성등 다 dfs문 안에서 가능*/
                        stack.push(new Node(j, i));
                        visit[i][j] = true;
                        dfs(i, j);
                    }
                }
            }
            sb.append(worms).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        worms++;

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            for (int i = 0; i < 4; i++) {
                curX = node.x + moveX[i];
                curY = node.y + moveY[i];

                if (checkBoundary(curX, curY) && !visit[curY][curX] && map[curY][curX] == 1) {
                    stack.push(new Node(curX, curY));
                    visit[curY][curX] = true;
                }
            }

        }
    }

    private static boolean checkBoundary(int x, int y) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int nodeCases = Integer.parseInt(st.nextToken());
        int edgeCases = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        int[][] nodeArr = new int[nodeCases + 1][nodeCases + 1];
        boolean[] visited = new boolean[nodeCases + 1];

        /*ToDo. 노드간 간선 연결 초기화 */
        for (int i = 1; i <= edgeCases; i++) {
            st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            nodeArr[column][row] = 1;
            nodeArr[row][column] = 1;
        }

        dfs(startNode, nodeArr, visited);

        visited = new boolean[nodeCases + 1];
        sb.append("\n");

        bfs(startNode, nodeArr, visited);

        System.out.println(sb);

    }

    private static void dfs(int start, int[][] nodeArr, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
//        visited[start] = true;

        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            if(visited[curNode]) {
                continue;
            }
            visited[curNode] = true;
            sb.append(curNode).append(" ");


            for (int i = nodeArr.length - 1; i >= 1; i--) {
                if (nodeArr[curNode][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    private static void bfs(int start, int[][] nodeArr, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int curNode = que.poll();
            sb.append(curNode).append(" ");

            for (int i = 1; i < nodeArr.length; i++) {
                if (nodeArr[curNode][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

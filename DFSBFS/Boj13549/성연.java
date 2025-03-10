import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int minSecond = Integer.MAX_VALUE;
    static int maxLoc = 100000;
    static boolean[] visited;
    static int startPoint;
    static int endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());
        visited = new boolean[maxLoc + 1];

        bfs();

        System.out.println(minSecond);
    }

    private static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(startPoint, 0));

        while(!que.isEmpty()) {
            Node node = que.poll();
            visited[node.x] = true;

            if(node.x == endPoint) {
                minSecond = Math.min(minSecond, node.second);
            }

            if(node.x * 2<= maxLoc && visited[node.x *2] == false) {
                que.offer(new Node(node.x * 2 , node.second));
            }

            if(node.x + 1 <= maxLoc && visited[node.x + 1] == false) {
                que.offer(new Node(node.x + 1 , node.second + 1));
            }

            if(node.x - 1 >= 0 && visited[node.x - 1] == false) {
                que.offer(new Node(node.x - 1 , node.second + 1));
            }

        }
    }

    private static class Node {
        int x;
        int second;

        public Node(int x, int second) {
            this.x = x;
            this.second = second;
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*ToDo. computers 노드간의 간선 연결 확인용 2차원 int 배열, 방문한 노드인지 확인할 1차원 boolean 배열 초기화 */
        int computerCases = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        int[][] computers = new int[computerCases + 1][computerCases + 1]; // 인덱스 노드 번호 동기화를 위한 +1
        boolean[] visited = new boolean[computerCases + 1];

        for(int i = 1; i <= edges; i++) {                           // 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            computers[column][row] = 1;
            computers[row][column] = 1;
        }

       

        bfs(computers, visited, 1);

        System.out.println(count);
    }

    private static void bfs(int[][] computer, boolean[] visited, int start) {
        /*Todo. BFS 탐색을 위한 해당 노드의 좌표를 받는 Queue 생성 */
        /*ToDo. 시작점 1번 컴퓨터 초기화 및 Queue offer */
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visited[1] = true;

        while(!que.isEmpty()) {
            int node = que.poll();

           for(int i = 1; i < computer.length; i++) {
               if(computer[node][i] == 1 && !visited[i]) {
                   que.offer(i);
                   visited[i] = true;
                   count++;
               }
           }

        }
    }

}

import java.io.*;
import java.util.StringTokenizer;



public class Main {

    static int [][] map;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점
        M = Integer.parseInt(st.nextToken());   //간선

        /*설명. 연결 한 그거 생성*/
        int [][] arr = new int[M][2];
        for (int i = 0; i <M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*설명 맵 생성*/
        map = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }


        visited = new boolean[N+1];
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if(visited[i] ==  false){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);


    }

    public static void dfs(int num){
        visited[num] = true;
        for (int i = 1; i <= N; i++) {
            if(map[num][i] == 1 && visited[i] == false){
                dfs(i);
            }

        }
    }
}

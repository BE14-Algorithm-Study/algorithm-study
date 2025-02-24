import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int com;
    static int pairs;
    static int[][]map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        com = Integer.parseInt(br.readLine());
        pairs = Integer.parseInt(br.readLine());
        int[][]arr = new int[pairs][2];


        //입력받은 2차원 배열 완성
        for (int i = 0; i < pairs; i++) {
            //이 타이밍에 숫자 두개 입력 받고
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                //이 타이밍에 받은 두개 꽂아넣기
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map = new int[com+1][com+1];
        for (int i = 0; i < pairs; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }

        visited = new boolean[com+1];

        dfs(1);
        int count = 0;
        for (int i = 1; i <= com; i++) {
            if (visited[i] == true) {
                count++;
            }
        }
        System.out.println(count-1);

    }




    public static void dfs(int num){
        visited[num] = true;
        for (int i = 1; i <= com ; i++) {
            if(map[num][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }
}

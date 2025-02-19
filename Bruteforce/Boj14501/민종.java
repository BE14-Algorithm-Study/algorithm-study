package S3.BOJ14501;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 퇴사
public class Main {

    static int N;
    static int[][] array;
    static boolean[] visited;
    static int money = 0;
    static List<Integer> income = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        array = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N+1];

        combination(array, visited, 1);
        int max = 0;
        for(int i : income){
            max = Math.max(max, i);
        }
        bw.write(max + "\n");
        bw.flush();
    }

    public static void combination(int[][] array, boolean[] visited, int day){
        if(day >= N + 2){
            return;
        }
        if(day == N + 1){
            income.add(money);
            return;
        }
        visited[day] = true;
        money += array[day][1];
        combination(array, visited, day + array[day][0]);
        visited[day] = false;
        money -= array[day][1];
        combination(array, visited, day + 1);
    }
}

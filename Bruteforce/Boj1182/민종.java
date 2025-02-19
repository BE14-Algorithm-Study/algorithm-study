package S2.BOJ1182;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 부분 수열의 합
public class Main {
    static int answer = 0;
    static int N;
    static int S;
    static List<List<Integer>> listArrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 1<=N<=20
        S = Integer.parseInt(st.nextToken());       // |S| <= 1,000,000

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
        combination(arr, visited, 0);

        bw.write(answer + "\n");
        bw.flush();
    }

    public static void combination(int[] arr, boolean[] visited, int index){
        if(index == arr.length){
            int sum = 0;
            int count = 0;
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sum += arr[i];
                    count++;
                }
            }
            if(sum == S && count > 0){
                answer++;
            }
            return;
        }

        visited[index] = true;
        combination(arr, visited, index+1);

        visited[index] = false;
        combination(arr, visited, index+1);
    }
}

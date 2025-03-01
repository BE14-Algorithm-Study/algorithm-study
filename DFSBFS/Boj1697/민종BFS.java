package notyet.BOJ1697;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class Main2 {
    static int N;               // 수빈
    static int K;               // 동생
    static boolean[] visited;   // 방문 배열
    static int[] time;          // 걸리는 시간 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K <= N) {
            bw.write(N - K + "\n");
        } else {
            time = new int[K+5];
            visited = new boolean[K+5];
            bfs(N);
            bw.write(time[K] + "\n");
        }
        bw.flush();
    }

    public static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while(!queue.isEmpty()) {
            num = queue.poll();
            int[] temp = {num+1, num-1, num*2};
            for(int i : temp){
                if(checkRange(i) && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    time[i] = time[num]+1;
                }
            }
        }
    }

    public static boolean checkRange(int num){
        return (num >= 0 && num < K+5);
    }
}

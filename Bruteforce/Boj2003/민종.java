package S4.BOJ2003;

import java.io.*;
import java.util.StringTokenizer;

// 수들의 합 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // N : 1 ~ 10000
        int M = Integer.parseInt(st.nextToken());       // M : 1 ~ 300,000,000

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수
        int count = 0;
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<N; j++){
                sum += arr[j];
                if(sum == M){
                    count++;
                    break;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //region Input
        int n = Integer.parseInt(br.readLine());

        // 걸리는 기간 T, 받을 수 있는 금액 P
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        StringTokenizer st;
        for(int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        //regionend

        sb.append(solve(n, t, p));
        System.out.println(sb);
    }

    static int solve(int n, int[] t, int[] p) {
        int[] dp = new int[n + 2];
        for(int i = 1; i <= n; i++) {
            int endDay = i + t[i];

            if(endDay <= n + 1) {
                dp[endDay] = Math.max(dp[i] + p[i], dp[endDay]);
            }

            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        // 끝나는 날짜에 담았으니까 n+1에 있음
        return dp[n + 1];
    }
}
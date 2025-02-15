import java.io.*;
import java.util.*;

/* ToDo. DP접근을 통한 최적화 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int retireDay = Integer.parseInt(br.readLine());

        int[] day = new int[retireDay + 1];
        int[] payment = new int[retireDay + 1];
        int maxProfit = 0;
        int[] dp = new int[retireDay + 2];

        for (int i = 1; i <= retireDay; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            payment[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = retireDay; i > 0; i--) {
            int nextDay = i + day[i];
            if (nextDay <= retireDay + 1) {
                dp[i] = Math.max(dp[i + 1], payment[i] + dp[nextDay]);
            } else {
                dp[i] = dp[i + 1];
            }
            maxProfit = Math.max(maxProfit, dp[i]);
        }

        System.out.println(maxProfit);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static int[] calcs;

    static int minResult = 1000000001;
    static int maxResult = -1000000001;

    static public void main(String[] args) throws IOException {
        input();
        solve(1, nums[0]);

        StringBuilder sb = new StringBuilder();
        sb.append(maxResult).append("\n").append(minResult);
        System.out.println(sb);
    }

    static private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        //region nums
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        //endregion

        //region calc
        calcs = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calcs[i] = Integer.parseInt(st.nextToken());
        }
        //endregion
    }

    static private void solve(int index, int result) {
        if (index == n) {
            minResult = Math.min(result, minResult);
            maxResult = Math.max(result, maxResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calcs[i] == 0) continue;
            calcs[i]--;
            if (i == 0) solve(index + 1, result + nums[index]);
            if (i == 1) solve(index + 1, result - nums[index]);
            if (i == 2) solve (index + 1, result * nums[index]);
            if (i == 3) solve(index + 1, result / nums[index]);
            calcs[i]++;
        }
    }
}

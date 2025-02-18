import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    static int n, s;
    static int[] nums;
    static int answer = 0;

    static int sum = 0;

    public static void main(String[] args) throws IOException {
        input();

        // 이 부분때문에 시간이 오래 걸리는 것 같은데 이거 없이 어떻게 해결하지ㅣ...
        for (int i = 1; i <= n; i++)
        {
            solve(0,0, i);
        }
        System.out.println(answer);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve(int now, int index, int count) {
        if(index == count && sum == s) {
            answer++;
            return;
        }

        for(int i = now; i < n; i++) {
            sum += nums[i];
            solve(i + 1, index + 1, count);
            sum -= nums[i];
        }
    }
}

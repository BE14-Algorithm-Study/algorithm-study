import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        input();

        StringBuilder sb = new StringBuilder();
        sb.append(solve());
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //region n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //endregion

        //region arr
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //endregion
    }

    static int solve() {
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = 0;
            // 숫자 하나만으로 m이 될 수 있으니까 i부터 확인
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == m) answer++;
            }
        }
        return answer;
    }
}

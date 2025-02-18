import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {

    static int[] talls = new int[9];
    static int last;

    public static void main (String[] args) throws IOException {

        input();
        solve();
        print();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            talls[i] = Integer.parseInt(br.readLine());
            sum += talls[i];
        }

        // 모든 키에서 100을 빼면 가짜 난쟁이 2명의 합이 나옴
        last = sum - 100;
    }

    public static void solve() {
        int eight = 0, nine = 0;
        for(int i = 0; i < 9; i++) {
            int temp1 = talls[i];
            for(int j = i + 1; j < 9; j++) {
                int temp2 = talls[j];

                // 가짜 난쟁이 2명 찾기
                if(temp1 + temp2 == last) {
                    eight = temp1;
                    nine = temp2;
                    break;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(talls[i] == eight || talls[i] == nine) {
                talls[i] = 0;
            }
        }

        Arrays.sort(talls);
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        // 0 두개가 맨 앞에 있을거니까(index : 0, 1) 2부터 시작
        for(int i = 2; i < 9; i++) {
            sb.append(talls[i] + "\n");
        }

        System.out.println(sb);
    }
}

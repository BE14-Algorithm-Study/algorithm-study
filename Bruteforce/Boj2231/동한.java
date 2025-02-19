import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동한 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int min = 1000001;
        int result = 0;
        br.close();
        for (int i = 1; i <= n; i++) {
            int loopInt = i;
            int digitSum = 0;
            while (loopInt > 0) {
                digitSum += loopInt % 10;
                loopInt /= 10;
            }
            if (i + digitSum == n) {
                min = Math.min(i , min);
                result = min;
            }
        }
        sb.append(result);
        System.out.println(sb);
    }
}

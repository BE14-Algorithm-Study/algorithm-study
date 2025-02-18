import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //region Input
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        //endregion

        int sum = -1;
        int minNum = 10001;
        for (int i = m; i <= n; i++) {
            //  i 제곱근의 제곱이 i와 같으면 완전제곱수
            int sqrt = (int) Math.sqrt(i);
            if(sqrt * sqrt == i) {
                sum += i;
                minNum = Math.min(minNum, i);
            }
        }

        // 처음에 -1로 시작했으니까 +1
        if(sum != -1) sum++;

        sb.append(sum + "\n");
        if(sum != -1) sb.append(minNum);
        System.out.println(sb);
    }
}

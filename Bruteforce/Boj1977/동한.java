import java.io.*;

public class 동한 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        br.close();
        int result = -1;
        int min = 10001;
        int sum = 0;
        for (int i = 1; i * i <= m; i++) {
            for (int j = n; j <= m; j++) {
                if (i * i == j) {
                    min = Math.min(j, min);
                    result = 1;
                    sum += j;
                }
            }
        }
        if (result != -1) {
            sb.append(sum + "\n");
            sb.append(min);
        } else {
            sb.append(result);
        }
        System.out.println(sb);
    }
}

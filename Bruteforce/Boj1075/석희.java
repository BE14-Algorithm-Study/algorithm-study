import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        // 시작 숫자는 1의자리, 10의 자리 모두 0으로 시작
        int answer = 0;
        int start = n - (n % 100);
        for (int i = 0; i < 100; i++) {
            if ((start + i) % f == 0) {
               answer = i;
               break;
            }
        }

        // java 8 기준 64ms
        StringBuilder sb = new StringBuilder();
        if(answer < 10) sb.append("0");
        sb.append(answer);
        System.out.println(sb);

        // java 8 기준 68ms
//        System.out.printf("%02d", answer);

        // java 8 기준 72ms
//        String strAnswer = String.format("%02d", answer);
//        sb.append(strAnswer);
//        System.out.println(sb);
    }
}

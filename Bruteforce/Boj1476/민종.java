package S5.BOJ1476;
// 날짜 계산
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());       // 1~15
        int S = Integer.parseInt(st.nextToken());       // 1~28
        int M = Integer.parseInt(st.nextToken());       // 1~19

        int year = 1;
        while(true){
            int e = (year-1)%15 + 1;
            int s = (year-1)%28 + 1;
            int m = (year-1)%19 + 1;

            if(e == E && s == S && m == M){
                break;
            }
            year++;
        }
        System.out.println(year);
    }
}

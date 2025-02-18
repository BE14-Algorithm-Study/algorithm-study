import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {

    static int n;       //  1 <= n <= 1000

    public static void main(String[] args) throws IOException {

        input();

        StringBuilder sb = new StringBuilder();
        sb.append(solve());
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    static int solve() {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(checkHansu(i)) answer++;
        }

        return answer;
    }

    static boolean checkHansuStr(int num) {
        if(num < 10) return true;

        String str = String.valueOf(num);
        int standard = str.charAt(0) - str.charAt(1);
        for(int i = 1; i < str.length() - 1; i++) {
            if(str.charAt(i) - str.charAt(i + 1) != standard)
                return false;
        }
        return true;
    }

    static boolean checkHansu(int num) {
        if(num < 10) return true;

        int last = num % 10;
        num = num / 10;
        int temp = num % 10;

        int standard = last - temp;
        while((num = num / 10) > 0) {
            last = temp;
            temp = num % 10;
            if(last - temp != standard) {
                return false;
            }
        }
        return true;
    }
}
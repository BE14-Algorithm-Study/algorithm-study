import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        int curNum = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        if(num <= 99) {
            answer = num;
        }
        else {
            for(int i = 101; i <= num; i++) {
                curNum = i;
                one = curNum % 10;
                curNum /= 10;
                two = curNum % 10;
                curNum /= 10;
                three = curNum % 10;

                if(three - two == two - one) {
                    answer++;
                }
            }
            answer += 99;
        }

        if(num == 1000) {
            answer--;
        }


        sb.append(answer);
        System.out.println(sb);
    }
}

package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//분해합
public class Boj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int answer = 0;  //생성자

        for (int i = 0; i < N; i++) {
            int num = i;
            int sum = 0;

            /*설명. 각 자리수 더한거*/
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            /*설명. (num 각자리수 다 더한거) + num => answer(생성자) /// answer 는 i 의 생성자*/
            if(sum + i == N){
                answer = i;
                break;
            }
        }
        System.out.println(answer);


    }
}

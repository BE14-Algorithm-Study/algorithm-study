package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 완전 제곱수
public class Boj1977 { //테스트 케이스는 돌아가는데 제출하면 틀렸습니다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int answer = 0;
        int min = Integer.MAX_VALUE;


        for (int i = N; i <= M; i++) {
            for (int j = 2; j <= 100; j++) {
                if(j*j == i){
                    answer += j*j;
                    if(min > j*j){
                        min = j*j;
                    }
                }
            }
        }

        if(answer == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
            System.out.println(min);
        }

    }


}

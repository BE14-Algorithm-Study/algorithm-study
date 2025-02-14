package BOJ1977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int min = 0;
        int sum = 0;
        for(int i=m; i<=n; i++){
            if(Math.sqrt(i) % 1 == 0){
                if(min == 0){
                    min = i;
                }
                sum += i;
            }
        }
        if(min == 0 && sum == 0){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}

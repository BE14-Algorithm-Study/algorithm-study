package BOJ1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int answer = n;
        for (int num = 100; num <= n; num++) {
            String number = num + "";
            String[] array = number.split("");
            int difference = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
            for (int i = 0; i < array.length - 1; i++) {
                int diff = Integer.parseInt(array[i]) - Integer.parseInt(array[i + 1]);
                if (diff != difference) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
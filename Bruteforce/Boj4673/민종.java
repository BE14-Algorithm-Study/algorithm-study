package S5.BOJ4673;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 셀프 넘버
public class Main {
    public static void main(String[] args) {
        boolean[] array = new boolean[10001];   // 1~10000 중에 셀프 넘버 찾기
        for(int i=1; i<=10000; i++){
            int result = d(i);
            if(result <= 10000){
                array[result] = true;
            }
        }

        for(int i=1; i<=10000; i++){
            if(!array[i]){
                System.out.println(i);
            }
        }
    }

    public static int d(int n){
        String number = n + "";
        String[] array = number.split("");
        for(int i=0; i<array.length; i++){
            n += Integer.parseInt(array[i]);
        }
        return n;
    }
}

package bruteforce;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ4673 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[10001];
        for(int i=1;i<=10000;i++){
            arr[i]=i;
        }
        for(int i=1;i<=10000;i++){
            int d=d(i);
            if(d<=10000){
                arr[d]=0;
            }
        }
        // stream 속도 테스트 -> 3배정도 느림
//        Arrays.stream(arr)
//                .filter(num->num!=0)
//                .forEach(num-> sb.append(num).append("\n"));
        for(int i=1;i<=10000;i++){
            if(arr[i]!=0){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int d(int i) {
        int result=i;
        while(i!=0){
            result+=(i%10);
            i/=10;
        }
        return result;
    }
}

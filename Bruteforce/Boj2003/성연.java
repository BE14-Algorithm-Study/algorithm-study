import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());
        int count = 0;
        int curSum = 0;
        int[] arr = new int[arrSize];
        int idx = 0;

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        idx = 1;

        for(int i = 0 ; i < arr.length; i++) {
            idx = i;
            while(curSum < targetNum && idx <= arr.length - 1) {
                curSum += arr[idx];
                if(curSum == targetNum) {
                    count++;
                }
                idx++;
            }
            curSum = 0;
        }



        sb.append(count);
        System.out.println(sb);
    }
}


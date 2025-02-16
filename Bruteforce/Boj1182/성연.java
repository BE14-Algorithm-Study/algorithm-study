import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int[] numArr;
    static int targetNum;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numArr = new int[Integer.parseInt(st.nextToken())];
        targetNum = Integer.parseInt(st.nextToken());
        int idx = 0;
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            numArr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }


        backTrack(0,0, 0);
        System.out.println(count);
    }

    private static void backTrack(int arrIdx, int sum, int depth) {
        if (arrIdx == numArr.length) {
            if (sum == targetNum && depth > 0) {
                count++;
            }
            return;
        }
        backTrack(arrIdx + 1, sum + numArr[arrIdx], depth + 1);

        backTrack(arrIdx + 1, sum, depth);
    }




}

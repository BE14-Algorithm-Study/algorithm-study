package S1.BOJ14888;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class Main {

    static int N;
    static int[] arr;
    static int plusCount = 0;
    static int minusCount = 0;
    static int multipleCount = 0;
    static int divisionCount = 0;
    static int[] calculation;
    static int max;
    static int min;
    static List<Integer> resultNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        plusCount = Integer.parseInt(st.nextToken());
        minusCount = Integer.parseInt(st.nextToken());
        multipleCount = Integer.parseInt(st.nextToken());
        divisionCount = Integer.parseInt(st.nextToken());
        resultNumbers = new ArrayList<>();
        calculation = new int[plusCount + minusCount + multipleCount + divisionCount];

        // 첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다.
        combination(plusCount, minusCount, multipleCount, divisionCount, 0);
        max = resultNumbers.get(0);
        min = resultNumbers.get(0);
        for(int i=0; i<resultNumbers.size(); i++) {
            max = Math.max(max, resultNumbers.get(i));
            min = Math.min(min, resultNumbers.get(i));
        }
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
    }

    public static int calculate(int a1, int calc, int a2){
        switch(calc){
            case 1:
                return a1 + a2;
            case 2:
                return a1 - a2;
            case 3:
                return a1 * a2;
            case 4 :
                return a1 / a2;
        }
        return 0;
    }

    public static void combination(int plusCount, int minusCount, int multipleCount, int divisionCount, int depth) {
        if(plusCount < 0 || minusCount < 0 || multipleCount < 0 || divisionCount < 0){
            return;
        }
        if (depth == calculation.length) {
            int result = arr[0];
            for(int i=0; i<calculation.length; i++){
                result = calculate(result, calculation[i], arr[i+1]);
            }
            resultNumbers.add(result);
            return;
        }
        calculation[depth] = 1;     // 더하기
        combination(plusCount - 1, minusCount, multipleCount, divisionCount, depth + 1);
        calculation[depth] = 2;     // 빼기
        combination(plusCount, minusCount - 1, multipleCount, divisionCount, depth + 1);
        calculation[depth] = 3;     // 곱하기
        combination(plusCount, minusCount, multipleCount - 1, divisionCount, depth + 1);
        calculation[depth] = 4;     // 나누기
        combination(plusCount, minusCount, multipleCount, divisionCount - 1, depth + 1);
    }
}
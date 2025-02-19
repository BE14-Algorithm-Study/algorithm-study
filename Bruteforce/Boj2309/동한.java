import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동한 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int[] result = new int[7];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int index1 = 0, index2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    index1 = i;
                    index2 = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == index1 || i == index2) {
                continue;
            }
            sb.append(arr[i] + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long startNum = Long.parseLong(st.nextToken());
        long targetNum = Long.parseLong(st.nextToken());

        while(targetNum != startNum) {
            if(targetNum % 2 != 0 && targetNum % 10 != 1) {
                count = -1;
                break;
            }

            if(targetNum == 1) {
                count = -1;
                break;
            }

            if(targetNum % 2 == 0) {
                targetNum /= 2;
                count++;
            } else if(targetNum % 10 == 1) {
                String str = String.valueOf(targetNum);
                targetNum = Long.parseLong(str.substring(0,str.length() -1));
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb) ;

    }
}

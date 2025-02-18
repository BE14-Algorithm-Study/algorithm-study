import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int minNum = Integer.parseInt(br.readLine());
        int maxNum = Integer.parseInt(br.readLine());
        int sum = 0;


        int squareRoot = (int)Math.sqrt(minNum) < Math.sqrt(minNum) ? (int)Math.sqrt(minNum) + 1 : (int)Math.sqrt(minNum);

        if((int)Math.pow(squareRoot, 2) > maxNum) {
            System.out.println("-1");
        } else {
            int maxSquareRoot = squareRoot;

            while (Math.pow(maxSquareRoot, 2) <= maxNum) {
                sum += Math.pow(maxSquareRoot, 2);
                maxSquareRoot++;
            }

            sb.append(sum).append("\n").append((int) Math.pow(squareRoot, 2));
            System.out.println(sb);
        }
    }
}

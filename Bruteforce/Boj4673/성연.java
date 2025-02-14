import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean[] d = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = i;
            int j = i;

            while (j > 0) {
                n += j % 10;
                j /= 10;
            }

            if (n < 10001) {
                d[n] = true;
            }
        }
        for (int i = 1; i < 10001; i++) {
            if (!d[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}

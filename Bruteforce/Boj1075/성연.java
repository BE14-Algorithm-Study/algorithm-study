import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(br.readLine());
        int divisorNum = Integer.parseInt(br.readLine());

        targetNum = (targetNum/100) * 100;

        while(targetNum%divisorNum != 0)
            targetNum++;

        targetNum %= 100;

        if(targetNum < 10) System.out.println("0" + targetNum);
        else System.out.println(targetNum);



    }
}

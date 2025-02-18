package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2501 {
    public static void main(String[] args) throws IOException {
        int count=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
                if(count==k){
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}

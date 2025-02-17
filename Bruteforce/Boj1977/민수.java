import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int m= Integer.parseInt(br.readLine());
        int n= Integer.parseInt(br.readLine());
        int sqrtM= (int) Math.sqrt(m);
        if(sqrtM*sqrtM!=m){
            sqrtM++;
        }
        int sum=0;
        int sqr=sqrtM*sqrtM;
        int min=sqr;
        while(sqr<=n){
            sum+=sqr;
            sqrtM++;
            sqr=sqrtM*sqrtM;
        }
        System.out.println((sum==0)?-1:sum+"\n"+min);
    }
}

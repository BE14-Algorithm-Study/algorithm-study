import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int f= Integer.parseInt(br.readLine());
        int firstN=n/100*100;
        int min=100;
        for(int i=0;i<=99;i++){
            if((firstN+i)%f==0&&i<min){
                min=i;
            }
        }
        System.out.println((min<=9)?"0"+min:min);
//        System.out.println((min<=9)?(min==0)?"00":"0"+min:min);
    }
}

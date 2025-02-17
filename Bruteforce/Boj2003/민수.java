package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        

        // region 100ms 풀이
        /*int p1=0,p2=0,sum=arr[p1],count=0;
        try{
            while(true){
                if(p1==n||p2==n){break;}
                if(sum==m){
                    count++;
                    sum-=arr[p1];
                    p1++;
                    p2++;
                    sum+=arr[p2];
                }else if(sum>m){
                    sum-=arr[p1];
                    p1++;
                }else{
                    p2++;
                    sum+=arr[p2];
                }

            }
        }
        catch (Exception e){        }*/
        // endregion

        // region 144ms 풀이
        /*while(true){
            sum=0;
            if(p1==n||p2==n){break;}
            for(int i=p1;i<=p2;i++){
                sum+=arr[i];
            }
            if(sum==m){
                count++;
                p1++;
                p2++;
            }else if(sum>m){
                p1++;
            } else {
                p2++;
            }
        }*/
        // endregion
        System.out.println(count);
    }
}

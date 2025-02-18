package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0,firstCard,secondCard,thirdCard;
        int tempAnswer;
        for(int i=0;i<n;i++){
            firstCard=arr[i];
            if (firstCard>m){
                continue;
            }
            for(int j=i+1;j<n;j++){
                secondCard=arr[j];
                if(firstCard+secondCard>m){
                    continue;
                }
                for(int k=j+1;k<n;k++){
                    thirdCard=arr[k];
                    tempAnswer=firstCard+secondCard+thirdCard;
                    if(tempAnswer>m){
                        continue;
                    }
                    if((m-answer)>(m-tempAnswer)){
                        if(tempAnswer==m){
                            System.out.println(tempAnswer);
                            return;
                        }
                        answer=tempAnswer;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}


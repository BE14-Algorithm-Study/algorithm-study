package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int segSum=0;
        int curNum;
        boolean flag=true;

        int countDigits=0;
        int digitN=n;
        while(digitN>0){
            digitN/=10;
            countDigits++;
        }

        for(int i=n-countDigits*9;i<=n;i++){
            // 현재 숫자 및 분해합 초기화
            curNum=i;
            segSum=0;
            // 분해합 계산
            segSum+=curNum;
            while(curNum>0){
                segSum+=curNum%10;
                curNum/=10;
            }
            if(segSum==n){
                System.out.println(i);
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println(0);
        }
    }
}

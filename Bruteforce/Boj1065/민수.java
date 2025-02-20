package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1065 {
    public static void main(String[] args) throws IOException {
        firstSolution();
        secondSolution();
        // 복습 차원에서 한번 더 풀이.
        // 동작 방식을 둘이 동일함
    }

    private static void secondSolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n<100){
            System.out.println(n);
            return;
        } else if (n==1000) {
            System.out.println(144);
            return;
        }else{
            if(n<=110){
                System.out.println(99);
                return;
            }else{
                int count=99;
                int firstDigit, secondDigit, thirdDigit;
                for(int i=111;i<=n;i++){
                    firstDigit = i/100;
                    secondDigit = i/10%10;
                    thirdDigit = i%10;
                    if((firstDigit-secondDigit)==(secondDigit-thirdDigit)){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }


    private static void firstSolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n<100){
            System.out.println(n);
            return;
        }else if(n==1000){
            System.out.println(144);
            return;
        }else {
            int count=99;
            int firstDigit, secondDigit, thirdDigit,sub1,sub2;
            for(int i=111;i<=n;i++){
                firstDigit=i/100;
                secondDigit=i%100/10;
                thirdDigit=i%10;
                sub1=firstDigit-secondDigit;
                sub2=secondDigit-thirdDigit;
                if(sub1==sub2){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());      // 배열의 갯수
        // 걸리는 시간, 보수
        int[][] schedule=new int[n+1][2];
        // region 입력

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            schedule[i][0]=Integer.parseInt(st.nextToken());
            schedule[i][1]=Integer.parseInt(st.nextToken());
        }

        // endregion
        // region 출력 확인 -> 확인 완료
        /*for(int[] i:schedule){
            System.out.println(Arrays.toString(i));
        }*/
        // endregion
        /* 설명:
        *   2의 n제곱만큼 for문 돌리면서 나오는 각 i 에 대해서
        *   i를 2로 나누면서 나머지를 살핌
        *   나머지가 1이면 해당 상담을 실행
        *   나머지가 0이면 해당 상담을 실행하지 않음
        *   상담을 실행할 때는 두가지를 고려
        *   1) 전 상담이 종료되었는지
        *   2) 현재 상담이 퇴사 전 종료되는지*/
        int pow= (int) Math.pow(2,n);
        int sumPay=0;
        int maxPay=0;
        for(int i=1;i<pow;i++){
            // 여기가 하나의 테스트 케이스
            sumPay=0;
            int cur=i;
            int endTime=0;
            int date=1;
            while(cur>0){
                int key=cur%2;
                if(key==1){ // 나머지가 1이면 해당 상담을 실행
                    // 전 상담이 종료되지 않았으면 다음 케이스로 넘어가야함
                    if(endTime>=date){
                        break;
                    }
                    // 퇴사날보다 (현재 날짜+상담 날짜)
                    if(n<schedule[date][0]-1+date){
                        break;
                    }
                    // 페이 추가
                    sumPay+=schedule[date][1];
                    // endTime 반영
                    endTime=date+schedule[date][0]-1;
                }
                // date 다음 날로 변경
                date++;
                cur/=2;
            }
            if(sumPay>maxPay){
                maxPay=sumPay;
            }
        }
        System.out.println(maxPay);
    }
}

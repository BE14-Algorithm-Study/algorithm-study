package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Boj2309 {
    public static void main(String[] args) throws IOException {
        otherSolution();
    }
    /* 설명: for문이 도는 범위가 극히 제한되므로 그냥 7중 for문 때림
     *   근데 분명히 나은 풀이가 있을 것 같음
     *   조합론이라던가...*/
    private static void mySolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[9];
        int[] result=new int[7];
        for(int i=0;i<9;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        for(int i=0;i<3;i++){
            for(int j=i+1;j<4;j++){
                for(int k=j+1;k<5;k++){
                    for(int l=k+1;l<6;l++){
                        for(int m=l+1;m<7;m++){
                            for(int n=m+1;n<8;n++){
                                for(int o=n+1;o<9;o++){
                                    if (arr[i]+arr[j]+arr[k]+arr[l]+arr[m]+arr[n]+arr[o]==100){
                                        result[0]=arr[i];
                                        result[1]=arr[j];
                                        result[2]=arr[k];
                                        result[3]=arr[l];
                                        result[4]=arr[m];
                                        result[5]=arr[n];
                                        result[6]=arr[o];
                                        Arrays.sort(result);
                                        for (int res: result){
                                            sb.append(res).append("\n");
                                        }
                                        System.out.println(sb);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void otherSolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[9];
        int sum=0;
        for(int i=0;i<9;i++){
            arr[i]= Integer.parseInt(br.readLine());
            sum+=arr[i];
        }

        int diff=sum-100;
        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++) {
                if (arr[i] + arr[j] == diff) {
                    arr[i] = 100;
                    arr[j] = 100;
                    Arrays.sort(arr);
                    for(int k=0;k<7;k++){
                        sb.append(arr[k]).append("\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1018 {
    // 예시 답안 두개
    static char[][] answer=makeAnswer();

    private static char[][] makeAnswer() {
        char[][] result=new char[8][8];
            for(int i=0;i<8;i+=2){
                result[i]="WBWBWBWB".toCharArray();
            }
            for(int i=1;i<8;i+=2){
                result[i]="BWBWBWBW".toCharArray();
            }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // 입력 -> charArray로 받음
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int y=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        char[][] map=new char[y][x];
        for(int i=0;i<y;i++){
            map[i]=br.readLine().toCharArray();
        }
        // region 입력 잘 되었는지 확인 -> 확인 완료
        /*for(int i=0;i<y;i++){
            System.out.println(Arrays.toString(map[i]));
        }*/
        // endregion
        int minChange=33;   // 가장 많이 바꿔야 하는게 32개이기 때문에 33으로 초기값 설정
        // 탐색 범위 제한
        for(int i=0;i<=y-8;i++){
            for(int j=0;j<=x-8;j++){
                // 좌상단 항목 하나만 보고 예시 답안과 비교
                // 32보다 크면 64-답
                int temp=compare(map,i,j);
                if(temp<minChange){
                    minChange=temp;
                }
            }
        }
        System.out.println(minChange);
    }
    static public int compare(char[][] arr, int a, int b){
        int count=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(answer[i][j]==arr[i+a][j+b]){
                    count++;
                }
            }
        }
        return (count>32)?64-count:count;
    }
}

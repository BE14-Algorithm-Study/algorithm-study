import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println(solution(land));
    }
    static int solution(int[][] land) {
        int answer = 0;

        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                int max=getDPMax(land[i-1], j);
                land[i][j]+=max;
            }
        }
        answer=getMax(land[land.length-1]);
        return answer;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    private static int getDPMax(int[] arr, int skipIndex) {
        int max=0;
        for(int i=0;i<4;i++){
            if(i==skipIndex){continue;}
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}

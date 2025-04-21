import java.util.Arrays;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
    }
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int max=0;
        for (int i=numbers.length-1;i>=0;i--){
            if(numbers[i]>=max){        // 뒷 큰수가 없는 경우
                max=numbers[i];         // max를 현재 값으로 갱신
                answer[i]=-1;           // answer 배열에 -1
            }
            else{                       // 뒷 큰수가 있는 경우
                if(max-numbers[i]==1){
                    answer[i]=max;
                    continue;
                }
                for(int j=i+1;j<numbers.length;j++){        // 현재 숫자를 기준으로 배열 뒷부분 탐색
                    if(numbers[j]>numbers[i]){              // 자신보다 큰 수를 찾으면
                        answer[i]=numbers[j];               // answer 배열에 기록
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

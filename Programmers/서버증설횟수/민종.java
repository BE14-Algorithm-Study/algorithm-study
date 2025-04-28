import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        int[] needCount = new int[24];
        int[] addCount = new int[24];
        for(int i=0; i<24; i++){
            needCount[i] = players[i] / m;          // m명 추가 시 서버 증설
        }

        for(int i=0; i<24; i++){
            int lackOfServer = needCount[i] - servers[i];
            if(lackOfServer > 0){
                addCount[i] = lackOfServer;
                for(int j=i; j<i+k; j++){           // 서버는 k시간동안 구동
                    if(j >= 24){                    // 마지막 부분은 24를 넘을 수 있으니 break문 추가
                        break;
                    }
                    servers[j] += lackOfServer;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<24; i++){
            answer += addCount[i];
        }
        
        return answer;
    }
}

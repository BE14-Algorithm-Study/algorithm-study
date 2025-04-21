class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int dp[][] = new int[land.length][4];
        
        for(int i = 0; i < 4; i++) dp[0][i] = land[0][i];
        
        for(int i = 1; i < land.length; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                int prevMax = 0;
                for(int k = 0; k < 4; k++)
                {
                    // 같은 열이라면 넘어가기
                    if(j == k) continue;
                    
                    // 바로 전행에 있는 값들 중 제일 큰 값 찾기
                    prevMax = Integer.max(prevMax, dp[i-1][k]);
                }
                
                // 현재 모든 행에 전행의 최대값 더해주기
                dp[i][j] = prevMax + land[i][j];
            }
        }
        
        for(int i = 0; i < 4; i++)
        {
            answer = Integer.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    static int row;
    static int column;
    int solution(int[][] land) {
        int answer = 0;
        row = land.length;
        column = land[0].length;
        
        int[][] maxValue = new int[row][column];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                maxValue[i][j] = land[i][j];
            }
        }
        for(int i=1; i<row; i++){
            for(int j=0; j<column; j++){
                maxValue[i][j] += getMaxValueFromRow(maxValue[i-1], j);
            }
        }
        for(int i=0; i<column; i++){
            answer = Math.max(answer, maxValue[row-1][i]);
        }
        return answer;
    }
    
    public int getMaxValueFromRow(int[] array, int index){
        int max = 0;
        for(int i=0; i<index; i++){
            max = Math.max(max, array[i]);
        }
        for(int i=index+1; i<array.length; i++){
            max = Math.max(max, array[i]);
        }
        return max;
    }
}

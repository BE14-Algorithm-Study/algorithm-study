import java.util.*;

class Solution {
    static Stack<Integer> numberStack = new Stack<>();
    static Stack<Integer> indexStack = new Stack<>();
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        numberStack.push(numbers[0]);
        indexStack.push(0);
        
        for(int i=1; i<numbers.length; i++){
            insertNumber(numbers[i], i, answer);
        }
        while(!numberStack.isEmpty()){
            numberStack.pop();
            int peekIndex = indexStack.pop();
            answer[peekIndex] = -1;
        }
        return answer;
    }
    
    public void insertNumber(int number, int index, int[] answer){
        while(!numberStack.isEmpty()){
            int peekNumber = numberStack.peek();
            if(peekNumber < number){
                numberStack.pop();                      // stack의 숫자 제거
                int peekIndex = indexStack.pop();
                answer[peekIndex] = number;             // 제거된 숫자의 인덱스부분에 큰 값 삽입(뒤에 있는 큰 수)
            } else {
                break;
            }
        }
        numberStack.push(number);
        indexStack.push(index);
    }
}

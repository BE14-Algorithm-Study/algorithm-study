import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        if(k >= enemy.length){
            return enemy.length;
        }
        
        int sum = 0;
        int kCount = k;
        for(int i=0; i<enemy.length; i++){
            answer++;
            addNumber(list, enemy[i]);
            sum += enemy[i];            // 합이 n을 넘으면
            if(sum > n){
                if(kCount > 0){
                    kCount--;
                    sum -= poll(list);  // 가장 큰 수를 뺀다.(무적권을 사용)
                } else {
                    return i;
                }
            }
        }
        return answer;
    }
    
    // 아래는 priorityQueue<Integer> 구현(큰 수를 우선으로 하는)
    
    public int peek(List<Integer> list){
        return list.get(0);
    }
    
    public int poll(List<Integer> list){
        int num = peek(list);
        removeNumber(list);
        return num;
    }
    
    public void removeNumber(List<Integer> list){
        changeEachOther(list, 0, list.size()-1);
        list.remove(list.size() - 1);
        int parentIndex = 0;
        while(true){
            
            int childIndex1 = parentIndex*2 + 1;
            int childIndex2 = parentIndex*2 + 2;
            if(childIndex1 >= list.size() || childIndex2 >= list.size()){
                return;
            }
            if(list.get(childIndex1) >= list.get(childIndex2)){
                if(list.get(parentIndex) < list.get(childIndex1)){
                    changeEachOther(list, parentIndex, childIndex1);
                    parentIndex = childIndex1;
                } else {
                    return;
                }
            } else {
                if(list.get(parentIndex) < list.get(childIndex2)){
                    changeEachOther(list, parentIndex, childIndex2);
                    parentIndex = childIndex2;
                } else {
                    return;
                }
            }
        }
    }
    
    public void addNumber(List<Integer> list, int num){
        list.add(num);
        int childIndex = list.size() - 1;
        while(true){
            if(childIndex == 0){
                return;
            }
            int parentIndex = (childIndex-1)/2;
            if(list.get(parentIndex) < list.get(childIndex)){
                changeEachOther(list, parentIndex, childIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }
    
    public void changeEachOther(List<Integer> list, int index1, int index2){
        int temp = list.get(index2);
        list.set(index2, list.get(index1));
        list.set(index1, temp);
    }
}

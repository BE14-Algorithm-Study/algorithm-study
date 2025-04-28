import java.util.*;

class Solution {
    static HashMap<Integer, Integer> leftMap = new HashMap<>();
    static HashMap<Integer, Integer> rightMap = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        for(int i=0; i<topping.length; i++){
            rightMap = mapAdd(rightMap, topping[i]);
        }
        
        for(int i=0; i<topping.length; i++){
            if(move(topping[i])){
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean move(int num){
        leftMap = mapAdd(leftMap, num);
        rightMap = mapRemove(rightMap, num);
        if(leftMap.size() == rightMap.size()){
            return true;
        } else {
            return false;
        }
    }
    
    public static HashMap<Integer, Integer> mapRemove(HashMap<Integer, Integer> hm, int num){
        hm.replace(num, hm.get(num)-1);
        if(hm.get(num) == 0){
            hm.remove(num);
        }
        return hm;
    }
    
    public static HashMap<Integer, Integer> mapAdd(HashMap<Integer, Integer> hm, int num){
        if(hm.containsKey(num)){
            hm.replace(num, hm.get(num)+1);
        } else {
            hm.put(num, 1);
        }
        return hm;
    }
}

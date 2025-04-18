import java.util.*;
class Solution {
    static Queue<Integer> deliverDistanceList;
    static Queue<Integer> pickupDistanceList;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        deliverDistanceList = getShortDistances(cap, n, deliveries);
        pickupDistanceList = getShortDistances(cap, n, pickups);
        // System.out.println(deliverDistanceList);
        // System.out.println(pickupDistanceList);
        while(!deliverDistanceList.isEmpty() && !pickupDistanceList.isEmpty()){
            answer += Math.max(deliverDistanceList.poll(), pickupDistanceList.poll());
        }
        if(deliverDistanceList.isEmpty()){
            while(!pickupDistanceList.isEmpty()){
                answer += pickupDistanceList.poll();
            }
        } else if(pickupDistanceList.isEmpty()){
            while(!deliverDistanceList.isEmpty()){
                answer += deliverDistanceList.poll();
            }
        }
        answer *= 2;
        return answer;
    }
    
    public Queue<Integer> getShortDistances(int cap, int n, int[] boxes){
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=n-1; i>=0; i--){
            if(sum == 0 && boxes[i] > 0){
                queue.add(i+1);
                sum += boxes[i];
            } else if(sum > 0 && boxes[i] > 0){
                sum += boxes[i];
            }
            while(sum >= cap){
                sum -= cap;
                if(sum > 0){
                    queue.add(i+1); 
                }
            }
        }
        return queue;
    }
}

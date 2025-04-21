public class 택배배달과수거하기 {
    static int lastDeliveryNode=0, lastPickupNode=0;
    public static void main(String[] args) {
        System.out.println(solution(4,5,new int[]{1,0,3,1,2},new int[]{0,3,0,4,0}));
        System.out.println(solution(2,7,new int[]{1,0,2,0,1,0,2},new int[]{0,2,0,1,0,2,0}));
        System.out.println(solution(1,5,new int[]{1,1,1,1,1},new int[]{0,0,0,0,0}));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long sumDistance = 0;

        boolean isDeliveryDone=false;
        boolean isPickupDone=false;

        lastDeliveryNode=getLastNode(deliveries, deliveries.length-1);
        lastPickupNode=getLastNode(pickups, pickups.length-1);
        if(lastPickupNode==-1){
            isPickupDone=true;
        }
        if(lastDeliveryNode==-1){
            isDeliveryDone=true;
        }


        while(!(isDeliveryDone&&isPickupDone)){   // 이 안에가 1번의 배달에 대한 내용
            int deliveryDistance=getLastNode(deliveries, lastDeliveryNode)+1;
            int pickupDistance=getLastNode(pickups, lastPickupNode)+1;
            sumDistance+=Math.max(deliveryDistance,pickupDistance)*2;
            if(!isDeliveryDone){
                isDeliveryDone=calculateDeliveryCap(deliveries, cap);
            }
            if(!isPickupDone){
                isPickupDone=calculatePickupCap(pickups, cap);
            }
        }
        return sumDistance;
    }

    public static boolean calculatePickupCap(int[] deliveries, int spaceLeft) {
        boolean isDone=false;
        while(spaceLeft>0){                   // 배달을 갈 박스를 카운트 하는 내용
            if(deliveries[lastPickupNode]<=spaceLeft){   // 마지막 집에 배달해야 하는게 남은 용량보다 적은 경우
                spaceLeft-=deliveries[lastPickupNode];
                deliveries[lastPickupNode]=0;
                lastPickupNode--;
            }// 마지막 집에서 픽업해야 하는게 남은 용량보다 큰 경우
            else{
                deliveries[lastPickupNode]-=spaceLeft;
                spaceLeft=0;
            }
            if(lastPickupNode==-1){   // 픽업은 끝남
                isDone=true;
                break;
            }
        }
        return isDone;
    }
    public static boolean calculateDeliveryCap(int[] deliveries, int spaceLeft) {
        boolean isDone=false;
        while(spaceLeft>0){                   // 배달을 갈 박스를 카운트 하는 내용
            if(deliveries[lastDeliveryNode]<=spaceLeft){   // 마지막 집에 배달해야 하는게 남은 용량보다 적은 경우
                spaceLeft-=deliveries[lastDeliveryNode];
                deliveries[lastDeliveryNode]=0;
                lastDeliveryNode--;
            }// 마지막 집에 배달해야 하는게 남은 용량보다 큰 경우
            else{
                deliveries[lastDeliveryNode]-=spaceLeft;
                spaceLeft=0;
            }
            if(lastDeliveryNode==-1){   // 배달은 끝남
                isDone=true;
                break;
            }
        }
        return isDone;
    }

    public static int getLastNode(int[] arr, int startNode){
        for(int i = startNode; i >= 0; i--){
            if(arr[i]!=0){
                return i;
            }
        }
        return -1;
    }
}

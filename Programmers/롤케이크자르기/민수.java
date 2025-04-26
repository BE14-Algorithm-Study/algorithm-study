public class 롤케이크자르기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }

    static public int solution(int[] topping) {
        int[] arr1=new int[1000000+1];
        int[] arr2=new int[1000000+1];
        int result=0;
        int index=0;
        int arr1Variety=0;
        int arr2Variety=0;

        for(int i=0;i<topping.length;i++){      // arr2에 초기값 셋팅
            if(arr2[topping[i]]==0){
                arr2Variety++;                  // 해당 번호의 토핑이 처음 추가되는거면 다양성 1 증가
            }
            arr2[topping[i]]++;                 // topping 번호별로 몇개씩 있는지 체크
        }

        for(int i=0;i<topping.length-1;i++){
            if(arr1[topping[i]]==0){
                arr1Variety++;
            }
            arr1[topping[i]]++;
            arr2[topping[i]]--;
            if(arr2[topping[i]]==0){
                arr2Variety--;
            }
            if(arr1Variety==arr2Variety){
                result++;
            }
        }
        return result;
    }
}

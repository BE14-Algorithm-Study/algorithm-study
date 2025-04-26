class Solution {
    static public int solution(int[] players, int m, int k) {
        int result = 0, currentServers=0;
        int[] servers=new int[24];
        for(int i=0;i<24;i++){
            if(i>=k){
                currentServers-=servers[i-k];
            }
            int neededServers=players[i]/m;
            if(neededServers>currentServers){
                int addedServers=neededServers-currentServers;
                result+=(addedServers);
                servers[i]=addedServers;
                currentServers=neededServers;
            }
        }
        return result;
    }
}

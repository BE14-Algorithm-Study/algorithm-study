import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 무인도여행 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        String[] maps=new String[]{"X591X","X1X5X","X231X", "1XXX1"};
        int[] answer=solution(maps);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] maps) {
        ArrayList<Integer> answer=new ArrayList<>();
        map=drawMap(maps);      /* 설명: 데이터를 입력 받아 탐색 가능한 형태로 가공*/
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]!=0){
                    answer.add(bfs(j,i));
                }
            }
        }
        if(answer.size()==0){
            return new int[]{-1};
        }
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }

    public static int bfs(int x, int y){
        int sum=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x, y});
        sum+=map[y][x];
        map[y][x]=0;
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int curX=cur[0];
            int curY=cur[1];
            for(int i=0;i<4;i++){
                int nextX=curX+dx[i];
                int nextY=curY+dy[i];
                if(nextX<0||nextX>=map[0].length||nextY<0||nextY>=map.length||map[nextY][nextX]==0){
                    continue;
                }
                sum+=map[nextY][nextX];
                queue.add(new int[]{nextX, nextY});
                map[nextY][nextX]=0;
            }
        }
        return sum;
    }

    /* 설명: 지도를 문자열로 입력받아 정수로 변환하는 함수*/
    public static int[][] drawMap(String[] map){
        int width=map[0].length();
        int height=map.length;
        int[][] resultMap=new int[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(map[i].charAt(j)=='X'){
                    resultMap[i][j]=0;
                }else{
                    resultMap[i][j]=map[i].charAt(j)-'0';
                }
            }
        }
        return resultMap;
    }
}

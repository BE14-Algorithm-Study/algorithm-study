package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int xSize=Integer.parseInt(st.nextToken());
        int ySize=Integer.parseInt(st.nextToken());
        int[][] map=new int[ySize][xSize];
        Queue<int[]> q=new LinkedList<>();
        boolean findZero=false;
        // map 을 보면서 1인 애들 싹 다 큐에 넣음
        // 0 하나라도 있는지 없는지도 확인
        for(int i=0;i<ySize;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<xSize;j++){
                int value=Integer.parseInt(st.nextToken());
                map[i][j]=value;
                if(value==1){
                    q.add(new int[]{j,i});
                }
                if(value==0){
                    findZero=true;
                }
            }
        }
        if(!findZero){
            System.out.println(0);
            return;
        }
        // 거기서부터 BFS
            // BFS 조건
                // 좌표 벗어나면 안됨
                // 방문하려는 좌표의 값이 0이어야 함
        int last=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int curX=cur[0];
            int curY=cur[1];
            for(int i=0;i<4;i++){
                int nextX=curX+dx[i];
                int nextY=curY+dy[i];
                if(nextY<0||nextX<0||nextX>=xSize||nextY>=ySize){
                    continue;
                }
                if(map[nextY][nextX]==0){
                    q.add(new int[]{nextX,nextY});
                    last=map[nextY][nextX]=map[curY][curX]+1;
                }
            }
        }
        // BFS 끝나면 0인애 있는지 없는지 확인
            // 있으면 -1
        for(int i=0;i<ySize;i++){
            for(int j=0;j<xSize;j++){
                if(map[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(last-1);
        // 0인애 없으면 마지막 값을 출력
    }
}

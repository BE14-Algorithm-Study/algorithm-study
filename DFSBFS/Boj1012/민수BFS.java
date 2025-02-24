package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        // 입력 시작
        int numTestCase= Integer.parseInt(br.readLine());
        // 솔루션을 n번 실행
        for(int i=0;i<numTestCase;i++){
            solution(br, sb);
        }
        System.out.println(sb);
    }
    private static void solution(BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());
        // 맵 정보 입력
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        // 맵 만들기
        boolean[][] cabbage=new boolean[y][x];
        // 맵 그리기
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int inputX=Integer.parseInt(st.nextToken());
            int inputY=Integer.parseInt(st.nextToken());
            cabbage[inputY][inputX]=true;
        }

        // region 출력 테스트
        /*for(int i=0;i<y;i++){
            System.out.println(Arrays.toString(cabbage[i]));
        }*/
        // endregion
        int count=0;
        // 맵을 탐색하면서
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                // 배추가 있으면 해당 위치에서 BFS 시작
                if(cabbage[i][j]){
                    bfs(cabbage,i,j);// 방문한 곳은 배추를 없애버림
                    count++;
                }

            }
        }
        sb.append(count+"\n");

    }

    private static void bfs(boolean[][] cabbage, int startY, int startX) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{startY,startX});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nextY=cur[0]+dy[i];
                int nextX=cur[1]+dx[i];
                if(nextY>=0 && nextY<y && nextX>=0 && nextX<x){
                    if(cabbage[nextY][nextX]){
                        q.add(new int[]{nextY,nextX});
                        cabbage[nextY][nextX]=false;
                    }
                }
            }
        }
    }
}

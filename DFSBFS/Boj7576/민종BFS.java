package notyet.BOJ7576;

import java.io.*;
import java.util.*;

// 토마토
public class Main {

    static int M;
    static int N;
    static int[][] box;
    static boolean[][] visited;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static List<Location> tomatoes = new ArrayList<>();     // 익은 토마토 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());       // M : 상자의 가로 길이
        N = Integer.parseInt(st.nextToken());       // N : 상자의 세로 길이
        box = new int[N][M];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    tomatoes.add(new Location(i, j));       // 익은 토마토 위치
                }
            }
        }

        // 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
        // 토마토가 모두 익을 때까지의 최소 날짜를 출력
        visited = new boolean[N][M];
        bfs();

        boolean tomatoNot = false;
        int answer = 0;
        for(int i=0; i<N; i++){
            if(tomatoNot){
                break;
            }
            for(int j=0; j<M; j++){
                answer = Math.max(answer, box[i][j]);
                if(box[i][j] == 0){                         // 안 익은 토마토 존재
                    tomatoNot = true;
                    break;
                }
            }
        }
        if(tomatoNot){
            bw.write(-1 + "\n");
        } else {
            bw.write(answer-1 + "\n");
        }
        bw.flush();
    }

    public static void bfs(){
        Queue<Location> queue = new LinkedList<>();
        int x=0;
        int y=0;

        for(Location loc : tomatoes){
            queue.add(loc);
            x = loc.x;
            y = loc.y;
            visited[x][y] = true;
        }

        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            x = loc.x;
            y = loc.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (checkRange(nx, ny) && !visited[nx][ny] && box[nx][ny] != -1) {  // 빈 칸은 pass
                    queue.offer(new Location(nx, ny));
                    visited[nx][ny] = true;
                    box[nx][ny] = box[x][y] + 1;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y){                                 // 박스 범위 내 체크
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

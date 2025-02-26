import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int xSize;
    static int ySize;
    static int[][] map;
    static int count;
    static Queue<int[]>queue=new LinkedList<>();
    public static void main(String[] args) {
        try{
            while(true){
                solution();
            }
        } catch (Exception e) {
            System.out.println(sb);
        }
    }
    public static void solution() throws IOException {
        input();
        drawMap();
        count=0;
        bfs();
    }

    /*private static void printMap() {
        for(int[] line:map){
            System.out.println(Arrays.toString(line));
        }
    }*/

    public static void input() throws IOException {
        st=new StringTokenizer(br.readLine());
        xSize=Integer.parseInt(st.nextToken());
        ySize=Integer.parseInt(st.nextToken());
        if(xSize==ySize&&xSize==0){
            throw new RuntimeException();
        }
    }

    public static void drawMap() throws IOException {
        map=new int[ySize][xSize];
        for(int i=0;i<ySize;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<xSize;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void bfs(){
        for(int i=0;i<ySize;i++){
            for(int j=0;j<xSize;j++){
                if(map[i][j]==1){
                    count++;
                    map[i][j]=0;
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] curNode=queue.poll();
                        for(int nextY=curNode[0]-1;nextY<=curNode[0]+1;nextY++){
                            if(nextY<0||nextY>=ySize) continue;
                            for(int nextX=curNode[1]-1;nextX<=curNode[1]+1;nextX++){
                                if(nextX<0||nextX>=xSize) continue;
                                if(map[nextY][nextX]==1){
                                    queue.add(new int[]{nextY,nextX});
                                    map[nextY][nextX]=0;
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(count).append("\n");
    }
}

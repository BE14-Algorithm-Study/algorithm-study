import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1,0 , -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());
        int numInputs = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[ySize][xSize];            // 처음에는 다 false
        for(int i=0;i<numInputs;i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int nextY = startY;nextY<endY;nextY++){
                for(int nextX = startX;nextX<endX;nextX++){
                    visited[nextY][nextX] = true;
                }
            }
        }
        int countArea=0;
        ArrayList<Integer> countNodes=new ArrayList<>();
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<ySize;i++){
            for(int j=0;j<xSize;j++){
                if(!visited[i][j]){     // false가 방문 안한 것
                    countArea++;
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});
                    int countNode=1;
                    while(!queue.isEmpty()){
                        int[] curNode=queue.poll();
                        for(int di=0;di<4;di++){
                            int nextX = curNode[1]+dx[di];
                            int nextY = curNode[0]+dy[di];
                            if (nextX<0||nextX>=xSize||nextY<0||nextY>=ySize){
                                continue;
                            }
                            if (!visited[nextY][nextX]){
                                queue.add(new int[]{nextY, nextX});
                                visited[nextY][nextX]=true;
                                countNode++;
                            }
                        }
                    }
                    countNodes.add(countNode);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(countArea).append("\n");
        Collections.sort(countNodes);
        for(int i=0;i<countNodes.size();i++){
            sb.append(countNodes.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}

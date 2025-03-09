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
    static int[][] moves = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public static void main(String[] args) throws IOException {
        int numTestCases= Integer.parseInt(br.readLine());
        for(int i=0;i<numTestCases;i++){
            solution();
        }
        System.out.println(sb);
    }

    private static void solution() throws IOException {
        int boardSize= Integer.parseInt(br.readLine());
        int[][] board=new int[boardSize][boardSize];
        int[] startPosition=new int[2];
        st=new StringTokenizer(br.readLine());
        startPosition[0]=Integer.parseInt(st.nextToken());
        startPosition[1]=Integer.parseInt(st.nextToken());
        int[] goalPosition=new int[2];
        st=new StringTokenizer(br.readLine());
        goalPosition[0]=Integer.parseInt(st.nextToken());
        goalPosition[1]=Integer.parseInt(st.nextToken());
        if(Arrays.equals(startPosition, goalPosition)) {
            sb.append(0).append("\n");
            return;
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.add(startPosition);
        while(!queue.isEmpty()){
            int[] curPosition=queue.poll();
                for (int i = 0; i < 8; i++) {
                    int[] newPosition=new int[2];
                    newPosition[0]=curPosition[0]+moves[i][0];
                    if (newPosition[0]<0||newPosition[0]>=boardSize)continue;
                    newPosition[1]=curPosition[1]+moves[i][1];
                    if (newPosition[1]<0||newPosition[1]>=boardSize)continue;
                    if(board[newPosition[0]][newPosition[1]]==0||board[newPosition[0]][newPosition[1]]-board[curPosition[0]][curPosition[1]]>=2){
                        board[newPosition[0]][newPosition[1]]=board[curPosition[0]][curPosition[1]]+1;
                        if(Arrays.equals(newPosition,goalPosition)){
                            sb.append(board[newPosition[0]][newPosition[1]]).append("\n");
                            return;
                        }
                        queue.add(newPosition);
                    }
            }
        }
    }
}

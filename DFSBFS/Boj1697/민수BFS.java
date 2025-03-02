package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int curNode=Integer.parseInt(st.nextToken());
        int targetNode=Integer.parseInt(st.nextToken());
        Queue<Integer>queue=new LinkedList<>();
        int[] visited=new int[100000+1];
        queue.add(curNode);
        visited[curNode]=0;
        int nextNode1, nextNode2, nextNode3;

        while(!queue.isEmpty()){
            if(curNode==targetNode){
                break;
            }
            curNode=queue.poll();
            nextNode1=curNode+1;
            nextNode2=curNode-1;
            nextNode3=curNode*2;
            if(nextNode1<=100000 && visited[nextNode1]==0){
                queue.add(nextNode1);
                visited[nextNode1]=visited[curNode]+1;
            }if(nextNode2>=0&&visited[nextNode2]==0){
                queue.add(nextNode2);
                visited[nextNode2]=visited[curNode]+1;
            }if(nextNode3<=100000&&visited[nextNode3]==0){
                queue.add(nextNode3);
                visited[nextNode3]=visited[curNode]+1;
            }
        }
        System.out.println(visited[targetNode]);
    }
}

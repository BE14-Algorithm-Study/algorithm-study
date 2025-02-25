package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int numNodes= Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr=new ArrayList[numNodes+1];
        for(int i=1;i<=numNodes;i++){
            arr[i]=new ArrayList<>();
        }
        int[] parent=new int[numNodes+1];

        StringTokenizer st;
        for(int i=1;i<numNodes;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        parent[1]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int curNode=q.poll();
            for(int i=0;i<arr[curNode].size();i++){
                int nextNode=arr[curNode].get(i);
                if(parent[nextNode]==0){
                    parent[nextNode]=curNode;
                    q.add(nextNode);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=2;i<=numNodes;i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}

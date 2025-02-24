package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260 {
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodeNum,inputNum, startNum;
        st=new StringTokenizer(br.readLine());
        nodeNum=Integer.parseInt(st.nextToken());
        inputNum=Integer.parseInt(st.nextToken());
        startNum=Integer.parseInt(st.nextToken());
        network=new ArrayList[nodeNum+1];      // 번호와 인덱스를 일치시키기 위함
        for(int i=1;i<=nodeNum;i++){
            network[i]=new ArrayList<>();
        }
        visited=new boolean[nodeNum+1];         // 방문 배열 초기화
        /* 설명: 그래프에 정보 입력*/
        for(int i=1;i<=inputNum;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }
        /* 설명: 정렬*/
        for(int i=1;i<=nodeNum;i++){
            Collections.sort(network[i]);
        }
        dfs(startNum);
        sb.append("\n");
        visited=new boolean[nodeNum+1];
        bfs(startNum);
        System.out.println(sb);
    }

    private static void bfs(int startNum) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(startNum);
        sb.append(startNum+" ");
        visited[startNum]=true;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int i=0;i<network[cur].size();i++){
                int nextNode=network[cur].get(i);
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    sb.append(nextNode+" ");
                    visited[nextNode]=true;
                }
            }
        }
    }

    private static void dfs(int curNode) {
        visited[curNode]=true;              // 현재 노드 방문 처리
        sb.append(curNode+" ");             // sb에 붙이기
        for(int i=0;i<network[curNode].size();i++){
            if(!visited[network[curNode].get(i)]){
                dfs(network[curNode].get(i));
            }
        }
    }
}

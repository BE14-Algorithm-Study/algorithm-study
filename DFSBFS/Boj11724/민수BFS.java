package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11724 {
    public static void main(String[] args) throws IOException {
        arraySolution();
    }

    private static void arraySolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        // 정점의 개수 n과 간선의 개수 m 입력
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        // n x n 배열 활용 풀이
        boolean[][] graph=new boolean[n+1][n+1];
        boolean[] visited=new boolean[n+1];
        int temp1, temp2;
        // n x n 배열에 입력값 대입
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            temp1=Integer.parseInt(st.nextToken());
            temp2=Integer.parseInt(st.nextToken());
            graph[temp1][temp2]=true;
            graph[temp2][temp1]=true;
        }
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        // 각 정점을 탐색
        for(int i=1;i<=n;i++){
            if(!visited[i]){// 방문한 적이 없으면
                // 방문 처리
                visited[i]=true;
                // 카운트 증가
                count++;
                // 연결 노드 방문 처리
                q.add(i);
                while(!q.isEmpty()){
                    int temp=q.poll();
                    for(int j=1;j<=n;j++){
                        if (graph[temp][j]/*연결되어있고*/ && /*방문한 적이 없으면*/!visited[j]){
                            visited[j]=true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void arrayListSolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int numNodes,numConnections;
        StringTokenizer st=new StringTokenizer(br.readLine());
        numNodes=Integer.parseInt(st.nextToken());
        numConnections=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph=new ArrayList[numNodes+1];
        boolean[] visited=new boolean[numNodes+1];
        for(int i=1;i<=numNodes;i++){
            graph[i]=new ArrayList<>();
        }
        // region 그래프에 정보 입력
        for(int i=1;i<=numConnections;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // endregion
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        // 1부터 n번까지 노드에 대해
        for(int i=1;i<=numNodes;i++){
            // 방문하지 않았으면
            if(!visited[i]){
                // 방문 처리
                visited[i]=true;
                // 새로운 연결 요소이므로 카운트 증가
                count++;
                // 연결된 요소들을 탐색
                queue.add(i);
                while(!queue.isEmpty()){
                    int curNode=queue.poll();
                    for (int j=0;j<graph[curNode].size();j++){
                        if(!visited[graph[curNode].get(j)]){
                            visited[graph[curNode].get(j)]=true;
                            queue.add(graph[curNode].get(j));
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

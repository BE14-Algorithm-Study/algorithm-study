package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
    public static void main(String[] args) throws IOException {
        thirdSolution();
    }

    // 리스트를 활용해도 속도는 동일
    private static void thirdSolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer>[] network=new ArrayList[n+1];
        boolean[] visited=new boolean[n+1];
        for(int i=1;i<=n;i++){
            network[i]=new ArrayList<>();
        }
        int inputNum=Integer.parseInt(br.readLine());
        for(int i=1;i<=inputNum;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        visited[1]=true;
        int count=0;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int i=0;i<network[cur].size();i++){
                int next=network[cur].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(next);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // n*n 배열을 활용한 솔루션
    /*private static void secondSolution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int numCom=Integer.parseInt(br.readLine());
        int[][] network=new int[numCom+1][numCom+1];      // 번호와 인덱스를 일치시키기 위해 +1
        boolean[] visited=new boolean[numCom+1];           // 방문 처리를 위한 배열
        int numNetworks=Integer.parseInt(br.readLine());
        // a를 보고도 b와의 연결이 확인되고
        // b를 보고도 a와의 연결을 확인할 수 있도록
        // 대각선 방향으로 대칭인 그래프
        for(int i=1;i<=numNetworks;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            network[a][b]=1;
            network[b][a]=1;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(1);                               // 1부터 탐색 시작
        visited[1]=true;
        int count=0;
        while(!q.isEmpty()){
            int cur=q.poll();                   // 큐에서 한개 뽑아서
            // 다음 방문할 컴퓨터 확인
            for(int i=1;i<=numCom;i++){        // 모든 컴퓨터에 대해
                if(i==cur){                     // 자기 자신에 대해서는 패스
                    continue;
                }
                if(network[cur][i]==1 && !visited[i]){      // 현재 컴퓨터와 연결되어 있고, 방문 기록이 없으면
                    q.add(i);
                    count++;                                // 감염 카운트
                    // 방문 처리
                    visited[i]=true;
                }
            }
        }
        System.out.println(count);
    }*/
    /*public static void firstSolution() throws IOException {
        // 네트워크 정보 입력
        // n+1 X n+1 배열 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());// 컴퓨터의 갯수
        int M = Integer.parseInt(br.readLine());// 주어지는 네트워크의 갯수
        boolean[][] network=new boolean[N+1][N+1];
        // 배열에 정보 입력
        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            network[temp1][temp2]=true;
            network[temp2][temp1]=true;
        }
        // 배열에 정보 입력 완료
        // 방문 배열 생성
        // n+1
        boolean[] visited=new boolean[N+1];
        // bfs 실행
        // 스택 활용
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        visited[1]=true;
        int count=0;
        while(!queue.isEmpty()){

            // poll 하면서 방문 처리 (중요) 하면 안됨
            // poll 하면서 count 증가 중요 하면 안됨
            int cur=queue.poll();
//            System.out.println("cur = " + cur);
            // 다음 탐색은 네트워크 정보 순회
            for(int i=1;i<=N;i++){
                // 현재 네트워크랑 연결되어 있고
                // 방문 기록이 없는 경우

                if(network[cur][i]&&!visited[i]){
//                    System.out.println("i = " + i);
                    queue.add(i);
                    visited[i]=true;
                    count++;
                }
            }
//            System.out.println("network = " + Arrays.toString(network[cur]));
//            System.out.println("Arrays.toString(visited) = " + Arrays.toString(visited));
        }
        System.out.println(count);
    }*/
}

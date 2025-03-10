//앞으로 나랑 약속 하나 하자
//앞으로 내가 만드는 bfs 함수는 기능이 딱 하나야
//너비 우선 탐색 딱 하나
//맵에 기록을 남길지 안남길지는 선택할 수 있지만
//대부분의 다른 변주들은 외부에서 처리하도록 하자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int maxHeight = 0;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //사이즈
        size = Integer.parseInt(br.readLine());
        //지도 작성
        StringTokenizer st;
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < map[i][j]) {
                    maxHeight = map[i][j];
                }
            }
        }
        //수위가 1부터 최고 높이 직전으로 오를 때 까지의 지도를 생성
        //생성이 아니라 그냥 1씩 빼면 되잖아?
        int result = 0;
        for (int i = 1; i < maxHeight; i++) {
            int[][] curMap = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    curMap[j][k] = map[j][k] - i;
                }
            }

            int temp = countArea(curMap);
            if (result < temp) {
                result = temp;
            }
        }
        if (result == 0) {
            result = 1;
        }
        System.out.println(result);
        //각 지도에 대해서 bfs를 실행
        //결과값=안전 영역의 갯수
        //이를 위해서는 각 셀에 대해서 순차적으로 bfs를 실행해야 함
    }

    //map을 받아와서 영역의 갯수를 리턴해주는 함수
    static int countArea(int[][] newMap) {
        //셀 하나 단위로 이동하면서 bfs를 실행
        //bfs가 실행되면 카운트 증가
        //최종 카운트를 리턴
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(newMap[i][j] <= 0)) {
                    newMap = bfs(newMap, new int[]{i, j});
                    count += 1;
                }
            }
        }
        return count;
    }

    //이동 조건: 0이하의 자연수이면 이동하지 못함
    //방문 처리: 해당 셀의 값=0
    //방문 처리가 완료된 NewMap을 리턴
    static int[][] bfs(int[][] newMap, int[] cur) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(cur);
        int curX, curY, nextX, nextY;
        while (!q.isEmpty()) {
            cur = q.poll();
            curX = cur[0];
            curY = cur[1];
            for (int i = 0; i < 4; i++) {
                nextX = curX + dx[i];
                nextY = curY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size || newMap[nextX][nextY] <= 0) {
                    continue;
                }
                newMap[nextX][nextY] = 0;
                q.offer(new int[]{nextX, nextY});
            }
        }
        return newMap;
    }
}

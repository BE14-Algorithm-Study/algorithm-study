import java.util.*;
class Solution {
    static int rows;
    static int columns;
    static String[][] map;
    static boolean[][] visited;
    static int move[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public int solution(String[] storage, String[] requests) {
        // 'A' : 지게차로 A 꺼내기(접근 가능 컨테이너)
        // 'BB' : 크레인으로 B 꺼내기(모든 컨테이너)
        rows = storage.length;
        columns = storage[0].length();
        map = new String[rows+2][columns+2];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                String container = "" + storage[i].charAt(j);
                map[i+1][j+1] = container;                          // 주위에 1칸 여유로 둘러서 새로운 map 생성
            }
        }
        // 문제 풀이
        for(int i=0; i<requests.length; i++){
            String command = requests[i].length() == 2 ? "crane" : "forklift";
            String target = requests[i].length() == 2 ? "" + requests[i].charAt(0) : requests[i];
            if(command.equals("crane")){
                pickAllTarget(target);
            } else {
                visited = new boolean[rows+2][columns+2];
                bfs(new Location(0,0), target);
            }
        }
        
        int answer = 0;
        for(int i=1; i<rows+1; i++){
            for(int j=1; j<columns+1; j++){
                if(map[i][j] != null){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void pickAllTarget(String target){           // 크레인으로 모든 컨테이너 회수
        for(int i=1; i<rows+1; i++){
            for(int j=1; j<columns+1; j++){
                if(map[i][j] == null){
                    continue;
                } else if(map[i][j].equals(target)){
                    map[i][j] = null;
                }
            }
        }
    }
    
    public void bfs(Location loc, String target){       // 지게차로 접근 가능한 컨테이너만 회수
        Queue<Location> queue = new LinkedList<>();
        int r = loc.r;
        int c = loc.c;
        queue.offer(loc);
        visited[r][c] = true;
        while(!queue.isEmpty()){
            loc = queue.poll();
            r = loc.r;
            c = loc.c;
            for(int i=0; i<4; i++){
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if(checkRange(nr, nc) && !visited[nr][nc]){
                    if(map[nr][nc] == null){                    // null이면 bfs 계속 진행
                        queue.offer(new Location(nr, nc));
                        visited[nr][nc] = true;
                    } else if(map[nr][nc].equals(target)){      // target이면 컨테이너 회수 후에 더 못 들어감
                        map[nr][nc] = null;
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    
    public boolean checkRange(int r, int c){
        return (r >= 0 && r < rows + 2 && c >= 0 && c < columns + 2);
    }
    
    static class Location {
        int r;
        int c;
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

import java.util.*;
class Solution {
    static int n;                   // map 세로 길이
    static int m;                   // map 가로 길이
    static boolean[][] visited;     // 방문 배열
    static int food;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public List<Integer> solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        // System.out.println("n : " + n);
        // System.out.println("m : " + m);
        visited = new boolean[n][m];
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    // System.out.println("i : " + i);
                    // System.out.println("j : " + j);
                    // System.out.println("dfs start");
                    food = 0;
                    dfs(new Location(i, j), maps);
                    // System.out.println("food : " + food);
                    list.add(food);
                }
            }
        }
        // System.out.println(list);
        Collections.sort(list);
        if(list.size() == 0){
            list.add(-1);
        }
        return list;
    }
    
    public void dfs(Location loc, String[] maps){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(loc);
        int x = loc.x;
        int y = loc.y;
        visited[x][y] = true;
        food += maps[x].charAt(y) - '0';
        
        while(!queue.isEmpty()){
            loc = queue.poll();
            x = loc.x;
            y = loc.y;
            for(int i=0; i<4; i++){
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if(checkRange(nx, ny) && !visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                    queue.offer(new Location(nx, ny));
                    visited[nx][ny] = true;
                    food += maps[nx].charAt(ny) - '0';
                }
            }
        }
    }
    
    public boolean checkRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    
    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

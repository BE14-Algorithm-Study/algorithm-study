import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int memberCases;
    static int member1;
    static int member2;
    static int edgeCases;
    static List<Integer>[] list;
    static int relation = -1;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memberCases = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        member1 = Integer.parseInt(st.nextToken());
        member2 = Integer.parseInt(st.nextToken());

        edgeCases = Integer.parseInt(br.readLine());

        list = new ArrayList[memberCases +1];
        for(int i = 1; i <= memberCases; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < edgeCases; i++) {
            st = new StringTokenizer(br.readLine());
            int member1 = Integer.parseInt(st.nextToken());
            int member2 = Integer.parseInt(st.nextToken());

            list[member1].add(member2);
            list[member2].add(member1);
        }

        visited = new boolean[memberCases +1];
        visited[member1] = true;
        dfs(0, member1);

        System.out.print(relation);
        br.close();
    }

    private static void dfs(int depth, int member) {

        if(member == member2) {
            relation = depth;
            return;
        }

        for(Integer findMember : list[member]) {
            if(!visited[findMember]) {
                visited[findMember] = true;
                dfs(depth + 1, findMember);
            }
        }
    }
}

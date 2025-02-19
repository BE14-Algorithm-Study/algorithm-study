import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    final static int boardSize = 8;

    static int n, m;
    static String[] newBoard;
    static String[][] correctBoard;          // 왼쪽 위가 흰색(0), 검은색(1)으로 시작


    public static void main(String[] args) throws IOException {
        input();
        settingBoard();

        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //region input n, m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //endregion

        //region input board
        newBoard = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            newBoard[i] = st.nextToken();
        }
        //endregion
    }

    static void settingBoard() {
        String white = "WBWBWBWB";
        String black = "BWBWBWBW";

        //region board
        correctBoard = new String[2][n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                correctBoard[0][i] = white;
                correctBoard[1][i] = black;
            } else {
                correctBoard[0][i] = black;
                correctBoard[1][i] = white;
            }
        }
        //endregion
    }

    static int solve() {
        int answer = 65;
        int hRange = n - boardSize;
        int wRange = m - boardSize;
        for (int hStart = 0; hStart <= hRange; hStart++) {
            for (int wStart = 0; wStart <= wRange; wStart++) {
                answer = Math.min(answer, checkBoard(hStart, wStart));
            }
        }
        return answer;
    }

    static int checkBoard(int hStart, int wStart) {
        int whiteCount = 0;
        int blackCount = 0;

        // 보드 탐색
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (newBoard[i + hStart].charAt(j + wStart) != correctBoard[0][i].charAt(j)) whiteCount++;
                else if (newBoard[i + hStart].charAt(j + wStart) != correctBoard[1][i].charAt(j)) blackCount++;
            }
        }

        return Math.min(whiteCount, blackCount);
    }
}

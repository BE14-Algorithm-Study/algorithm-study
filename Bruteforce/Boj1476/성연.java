import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());

        int curEarth = 1;
        int curSun = 1;
        int curMoon = 1;

        int year = 1;

        while(earth != curEarth || sun != curSun || moon != curMoon) { //세개 다 동일할때까지 반복
            curEarth = initializationYear(curEarth, 15);
            curSun = initializationYear(curSun, 28);
            curMoon = initializationYear(curMoon, 19);
            year++;
        }

        sb.append(year);
        System.out.println(sb);

    }

    private static int initializationYear(int planet, int resetYear) { //각 행성별 날짜초기화.
        planet++;
        if(planet == resetYear + 1) {
            planet = 1;
        }

        return planet;
    }
}

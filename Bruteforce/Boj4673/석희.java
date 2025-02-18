public class BOJ_4673 {
    final static int MAX_NUM = 10000;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        solve();
        System.out.println(sb);
    }

    static void solve() {
        boolean[] isSelfNum = new boolean[MAX_NUM + 1];

        for (int i = 1; i <= MAX_NUM; i++) {
            int sum = i;
            int temp = i;
            while(temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            if(sum <= MAX_NUM) isSelfNum[sum] = true;
        }

        for(int i = 1; i <= MAX_NUM; i++) {
            if(isSelfNum[i]) continue;
            sb.append(i).append("\n");
        }
    }
}

public class 동한 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean isSelfNum = false;
        // 셀프 넘버 find
        for (int i = 1; i <= 10000; i++) {
            // 셀프 넘버 find 로직
            // 셀프 넘버를 찾으면 continue 아니면 i를 sb.append()
            for (int j = 1; j < i; j++) {
                int digit = 0;
                int divide = j;
                while (divide > 0) {
                    digit += (divide % 10);
                    divide /= 10;
                }
                if (digit + j == i) {
                    isSelfNum = true;
                    break;
                }
            }
            if (!isSelfNum) {
                sb.append(i + "\n");
            } else {
                isSelfNum = false;
            }
        }
        System.out.println(sb);
    }
}

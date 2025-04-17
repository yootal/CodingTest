import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static class Info {
        int K;
        String num;

        public Info(int K, String num) {
            this.K = K;
            this.num = num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        N = num.length();
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Info> q = new ArrayDeque<>();
        boolean[][] check = new boolean[1000001][K];
        int ans = -1;
        q.offer(new Info(K, num));
        while (!q.isEmpty()) {
            Info cur = q.poll();
            if (cur.K == 0) {
                ans = Math.max(ans, Integer.parseInt(cur.num));
                continue;
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (!(i == 0 && cur.num.charAt(j) == '0')) {
                        String temp = swap(cur.num, i, j);
                        int tempNum = Integer.parseInt(temp);
                        if (!check[tempNum][cur.K - 1]) {
                            check[tempNum][cur.K - 1] = true;
                            q.offer(new Info(cur.K - 1, temp));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static String swap(String ori, int i, int j) {
        StringBuilder sb = new StringBuilder(ori);
        sb.setCharAt(i, ori.charAt(j));
        sb.setCharAt(j, ori.charAt(i));
        return sb.toString();
    }
}

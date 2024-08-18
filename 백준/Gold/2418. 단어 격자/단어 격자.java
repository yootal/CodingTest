import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        char[][] board = new char[H][W];
        for (int i = 0; i < H; i++) {
            String row = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        String find = br.readLine();
        long[][][] dp = new long[H][W][L];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == find.charAt(0)) {
                    dp[i][j][0] = 1;
                }
            }
        }
        for (int i = 1; i < L; i++) {
            char cur = find.charAt(i);
            char pre = find.charAt(i - 1);
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (board[j][k] == cur) {
                        for (int d = 0; d < 8; d++) {
                            int nx = j + dx[d];
                            int ny = k + dy[d];
                            if (nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] == pre) {
                                dp[j][k][i] += dp[nx][ny][i - 1];
                            }
                        }
                    }
                }
            }
        }
        long total = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == find.charAt(L - 1)) {
                    total += dp[i][j][L - 1];
                }
            }
        }
        System.out.println(total);
    }
}
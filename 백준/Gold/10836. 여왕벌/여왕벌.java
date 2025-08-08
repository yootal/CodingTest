import java.io.*;
import java.util.*;

public class Main {
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] grow = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                grow[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] addValue = new int[M * 2 - 1];
        for (int i = 0; i < N; i++) {
            int idx = 0;
            for (int j = 0; j < 3; j++) {
                addValue[idx] += j;
                idx += grow[i][j];
                if (idx < M * 2 - 1)
                    addValue[idx] -= j;
                if (idx == M * 2 - 1) break;
            }
        }
        for (int i = 1; i < M * 2 - 1; i++) {
            addValue[i] += addValue[i - 1];
        }
        int[][] bug = new int[M][M];
        for (int[] row : bug) Arrays.fill(row, 1);
        update(bug, addValue);
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                bug[i][j] = Math.max(Math.max(bug[i - 1][j], bug[i - 1][j - 1]), bug[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row : bug) {
            for (int x : row) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void update(int[][] bug, int[] addValue) {
        int idx = 0;
        for (int i = M - 1; i >= 0; i--) {
            bug[i][0] += addValue[idx++];
        }
        for (int j = 1; j < M; j++) {
            bug[0][j] += addValue[idx++];
        }
    }
}
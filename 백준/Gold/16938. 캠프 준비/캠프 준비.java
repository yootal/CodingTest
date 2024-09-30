import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R, X, cnt;
    static boolean[] check;
    static int[] score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        check = new boolean[1 << N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, Integer.MAX_VALUE, 0, 0, 0);
        System.out.println(cnt);
    }

    static void solve(int idx, int min, int max, int total, int flag) {
        if (max - min >= X && total >= L && total <= R && !check[flag]) {
            check[flag] = true;
            cnt++;
        }
        if (idx == N) {
            return;
        }
        if ((flag & (1 << idx)) == 0) {
            solve(idx + 1, Math.min(min, score[idx]), Math.max(max, score[idx]), total + score[idx], flag | (1 << idx));
        }
        solve(idx + 1, min, max, total, flag);
    }
}
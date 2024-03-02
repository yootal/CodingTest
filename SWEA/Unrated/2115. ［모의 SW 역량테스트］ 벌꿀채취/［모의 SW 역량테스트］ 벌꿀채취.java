import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { 1, 1, -1, -1 };
	static final int[] dy = { 1, -1, -1, 1 };
	static int N, M, C, ans, board[][], honey[][], value[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			honey = new int[2][M];
			value = new int[2];
			ans = 0;
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int row, int col, int cnt) {
		if (cnt == 2) {
			value[0] = 0;
			value[1] = 0;
			calcMax(0, 0, 0, 0);
			calcMax(0, 0, 0, 1);
			ans = Math.max(ans, value[0] + value[1]);
			return;
		}
		for (int i = row; i < N; i++) {
			for (int j = (i == row) ? col : 0; j <= N - M; j++) {
				for (int k = j; k < j + M; k++) {
					honey[cnt][k - j] = board[i][k];
				}
				dfs(i, j + M, cnt + 1);
			}
		}
	}

	static void calcMax(int idx, int size, int total, int who) {
		if (idx == M) {
			value[who] = Math.max(value[who], total);
			return;
		}
		if (size + honey[who][idx] <= C)
			calcMax(idx + 1, size + honey[who][idx], total + (int) Math.pow(honey[who][idx], 2), who);
		calcMax(idx + 1, size, total, who);
	}
}
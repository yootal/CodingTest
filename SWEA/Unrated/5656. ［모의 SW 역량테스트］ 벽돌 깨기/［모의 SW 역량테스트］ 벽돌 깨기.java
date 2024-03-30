import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, h, w, ans, board[][];
	static boolean vis[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			board = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(0);
			sb.append("#").append(tc + " ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void solve(int cnt) {
		if (cnt == N || ans == 0) {
			return;
		}
		for (int k = 0; k < w; k++) {
			int[][] temp = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					temp[i][j] = board[i][j];
				}
			}
			for (int i = 0; i < h; i++) {
				if (board[i][k] != 0) {
					vis = new boolean[h][w];
					pop(i, k);
					gravity();
					ans = Math.min(ans, count());
					solve(cnt + 1);
					break;
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					board[i][j] = temp[i][j];
				}
			}
		}
	}

	static void pop(int x, int y) {
		vis[x][y] = true;
		if (board[x][y] > 1) {
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
					spread(nx, ny, board[x][y] - 1, d);
				}
			}
		}
		board[x][y] = 0;
	}

	static void spread(int x, int y, int r, int d) {
		if (!vis[x][y])
			pop(x, y);
		if (r != 1) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
				spread(nx, ny, r - 1, d);
			}
		}
	}

	static void gravity() {
		for (int j = 0; j < w; j++) {
			for (int i = h - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] != 0) {
							swap(i, j, k, j);
							break;
						}
					}
				}
			}
		}
	}

	static void swap(int x1, int y1, int x2, int y2) {
		int temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}

	static int count() {
		int wallCnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] != 0)
					wallCnt++;
			}
		}
		return wallCnt;
	}
}
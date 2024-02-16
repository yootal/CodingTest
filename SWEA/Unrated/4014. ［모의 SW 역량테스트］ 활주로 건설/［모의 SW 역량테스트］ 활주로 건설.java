import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int X;
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		map = new int[20][20];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(tc).append(" ").append(solve()).append("\n");
		}
		System.out.print(sb);
	}

	static int solve() {
		int ans = 0;
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			if (check_row(i)) {
				ans++;
			}
		}
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			if (check_col(i)) {
				ans++;
			}
		}
		return ans;
	}

	static boolean limit(int x) {
		return x >= 0 && x < N;
	}

	static boolean check_row(int r) {
		for (int j = 0; j < N - 1; j++) {
			int nxt = j + 1;
			if (map[r][j] == map[r][nxt])
				continue;
			else if (map[r][j] + 1 == map[r][nxt]) {
				if (limit(j - X + 1)) {
					for (int k = j - X + 1; k <= j; k++) {
						if (!check[r][k] && map[r][k] == map[r][j]) {
							check[r][k] = true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			} else if (map[r][j] - 1 == map[r][nxt]) {
				if (limit(nxt + X - 1)) {
					for (int k = nxt; k <= nxt + X - 1; k++) {
						if (!check[r][k] && map[r][k] == map[r][nxt]) {
							check[r][k] = true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	static boolean check_col(int c) {
		for (int i = 0; i < N - 1; i++) {
			int nxt = i + 1;
			if (map[i][c] == map[nxt][c])
				continue;
			else if (map[i][c] + 1 == map[nxt][c]) {
				if (limit(i - X + 1)) {
					for (int k = i - X + 1; k <= i; k++) {
						if (!check[k][c] && map[k][c] == map[i][c]) {
							check[k][c] = true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			} else if (map[i][c] - 1 == map[nxt][c]) {
				if (limit(nxt + X - 1)) {
					for (int k = nxt; k <= nxt + X - 1; k++) {
						if (!check[k][c] && map[k][c] == map[nxt][c]) {
							check[k][c] = true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, maxCnt, ans;
	static int selectedCore[];
	static int board[][];
	static ArrayList<Core> core;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			core = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						if (i > 0 && i < N - 1 && j > 0 && j < N - 1)
							core.add(new Core(i, j));
					}
				}
			}
			ans = Integer.MAX_VALUE;
			for (int i = core.size(); i > -1; i--) {
				maxCnt = i;
				selectedCore = new int[maxCnt];
				comb(0, 0);
				if (ans != Integer.MAX_VALUE)
					break;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static class Core {
		int x, y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void comb(int cnt, int idx) {
		if (cnt == maxCnt) {
			solve(0);
			return;
		}
		for (int i = idx; i < core.size(); i++) {
			selectedCore[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static void solve(int cnt) {
		if (cnt == maxCnt) {
			ans = Math.min(ans, countLink());
			return;
		}
		Core cur = core.get(selectedCore[cnt]);
		for (int d = 0; d < 4; d++) {
			if (link(cur.x, cur.y, d, cnt + 1)) {
				solve(cnt + 1);
				clear(cur.x, cur.y, d, cnt + 1);
			} else {
				clear(cur.x, cur.y, d, cnt + 1);
			}
		}
	}

	static boolean link(int x, int y, int d, int idx) {
		if (board[x][y] != 1) {
			board[x][y] -= idx;
		}
		if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
			return true;
		}
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
			return link(nx, ny, d, idx);
		} else {
			return false;
		}
	}

	static void clear(int x, int y, int d, int idx) {
		if (board[x][y] != 1) {
			board[x][y] += idx;
		}
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == -idx) {
			clear(nx, ny, d, idx);
		}
	}

	static int countLink() {
		int linkCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] < 0) {
					linkCnt++;
				}
			}
		}
		return linkCnt;
	}
}
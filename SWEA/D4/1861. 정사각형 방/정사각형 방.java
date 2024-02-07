import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int board[][] = new int[1000][1000];
	static int n;
	static int start;
	static int ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = dfs(i, j, 1);
					if (cnt > ans) {
						start = board[i][j];
						ans = cnt;
					} else if (cnt == ans) {
						start = Math.min(start, board[i][j]);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(start).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int dfs(int x, int y, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == board[x][y] + 1) {
				return dfs(nx, ny, cnt + 1);
			}
		}
		return cnt;
	}
}
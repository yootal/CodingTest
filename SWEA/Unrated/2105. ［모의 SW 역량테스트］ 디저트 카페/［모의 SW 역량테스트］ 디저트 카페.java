import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { 1, 1, -1, -1 };
	static final int[] dy = { 1, -1, -1, 1 };
	static int N, ans, board[][];
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = -1;
			set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					set.add(board[i][j]);
					dfs(i, j, 0, i, j);
					set.remove(board[i][j]);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static boolean limit(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	static void dfs(int x, int y, int d, int sx, int sy) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx == sx && ny == sy) {
			ans = Math.max(ans, set.size());
			return;
		}
		if (limit(nx, ny) && !set.contains(board[nx][ny])) {
			set.add(board[nx][ny]);
			dfs(nx, ny, d, sx, sy);
			set.remove(board[nx][ny]);
		}
		if (d == 3)
			return;
		d = (d + 1) % 4;
		nx = x + dx[d];
		ny = y + dy[d];
		if (nx == sx && ny == sy) {
			ans = Math.max(ans, set.size());
			return;
		}
		if (limit(nx, ny) && !set.contains(board[nx][ny])) {
			set.add(board[nx][ny]);
			dfs(nx, ny, d, sx, sy);
			set.remove(board[nx][ny]);
		}
	}
}
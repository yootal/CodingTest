import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] board;
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		ArrayDeque<int[]> start = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					start.offerLast(new int[] { i, j });
				}
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int[] x : start) {
			q.offerLast(x);
		}
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (board[nx][ny] == 0) {
						board[nx][ny] = board[cur[0]][cur[1]] + 1;
						q.offerLast(new int[] { nx, ny });
					}
				}
			}
		}
		boolean flag = true;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					flag = false;
					break;
				}
				ans = Math.max(ans, board[i][j]);
			}
			if (!flag)
				break;
		}
		System.out.println(flag ? ans - 1 : -1);
	}

}
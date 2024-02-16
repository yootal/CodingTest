import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static int[][] board;
	static boolean vis[] = new boolean[26];
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = (int) (row.charAt(j) - 'A');
			}
		}
		ans = 1;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		vis[board[x][y]] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !vis[board[nx][ny]]) {
				dfs(nx, ny, cnt+1);
			}
		}
		vis[board[x][y]] = false;
	}
}
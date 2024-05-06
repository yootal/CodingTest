import java.util.*;
import java.io.*;

class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char board[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'L') {
					boolean vis[][] = new boolean[N][M];
					vis[i][j] = true;
					ArrayDeque<int[]> q = new ArrayDeque<>();
					q.offer(new int[] { i, j, 0 });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						ans = Math.max(ans, cur[2]);
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 'L' && !vis[nx][ny]) {
								vis[nx][ny] = true;
								q.offer(new int[] { nx, ny, cur[2] + 1 });
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
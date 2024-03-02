import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static final int[] d0 = { 1, 2, 5, 6 };
	static final int[] d1 = { 1, 3, 6, 7 };
	static final int[] d2 = { 1, 2, 4, 7 };
	static final int[] d3 = { 1, 3, 4, 5 };
	static int ans, N, M, R, C, L, board[][];
	static boolean vis[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		board = new int[50][50];
		vis = new boolean[50][50];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					vis[i][j] = false;
				}
			}
			vis[R][C] = true;
			ans = 1;
			Queue<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] { R, C, 1 });
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				switch (board[cur[0]][cur[1]]) {
				case 1:
					for (int d = 0; d < 4; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				case 2:
					for (int d = 0; d < 4; d += 2) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				case 3:
					for (int d = 1; d < 4; d += 2) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				case 4:
					for (int d = 0; d <= 1; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				case 5:
					for (int d = 1; d <= 2; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				case 6:
					for (int d = 2; d <= 3; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				case 7:
					for (int d = 0; d < 4; d += 3) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (limit(nx, ny) && !vis[nx][ny] && cur[2] < L && directionCheck(d, board[nx][ny])) {
							vis[nx][ny] = true;
							ans++;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static boolean limit(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M && board[x][y] != 0);
	}

	static boolean directionCheck(int d, int dir) {

		switch (d) {
		case 0:
			for (int td : d0) {
				if (dir == td)
					return true;
			}
			break;
		case 1:
			for (int td : d1) {
				if (dir == td)
					return true;
			}
			break;
		case 2:
			for (int td : d2) {
				if (dir == td)
					return true;
			}
			break;
		case 3:
			for (int td : d3) {
				if (dir == td)
					return true;
			}
			break;
		}
		return false;
	}
}
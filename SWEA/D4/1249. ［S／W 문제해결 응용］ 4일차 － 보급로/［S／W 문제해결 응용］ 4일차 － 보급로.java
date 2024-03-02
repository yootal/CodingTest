import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];
		int[][] dist = new int[100][100];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = row.charAt(j) - '0';
				}
			}
			dist[0][0] = board[0][0];
			boolean[][] vis = new boolean[N][N];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			pq.offer(new int[] { 0, 0, dist[0][0] });
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int x = cur[0];
				int y = cur[1];
				int min = cur[2];
				if (vis[x][y])
					continue;
				vis[x][y] = true;
				if (x == N - 1 && y == N - 1)
					break;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny] && dist[nx][ny] > min + board[nx][ny]) {
						dist[nx][ny] = min + board[nx][ny];
						pq.offer(new int[] { nx, ny, dist[nx][ny] });
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dist[N - 1][N - 1]).append("\n");
		}
		System.out.print(sb);
	}
}
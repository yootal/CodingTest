import java.io.*;
import java.util.*;

class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };
	static int[][] block, point;
	static boolean vis[][], tempVis[][];
	static int pair;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 3; t++) {
			block = new int[6][6];
			vis = new boolean[6][6];
			point = new int[6][2];
			int idx = 0;
			for (int i = 0; i < 6; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 6; j++) {
					block[i][j] = Integer.parseInt(st.nextToken());
					if (block[i][j] != 0) {
						point[idx][0] = i;
						point[idx][1] = j;
						idx++;
					}
				}
			}
			pair = 0;
			for (int i = 0; i < 6; i++) {
				int cur[] = point[i];
				if (!vis[cur[0]][cur[1]]) {
					tempVis = new boolean[6][6];
					dfs(cur[0], cur[1], 0, 0, cur[0], cur[1]);
				}
			}
			if (pair != 3) {
				sb.append("no").append("\n");
			} else {
				sb.append("yes").append("\n");
			}
		}
		System.out.print(sb);
	}

	static void dfs(int x, int y, int cnt, int pre, int fx, int fy) {
		if (cnt == 2) {
			if (!vis[fx][fy] && !vis[x][y]) {
				vis[fx][fy] = true;
				vis[x][y] = true;
				pair++;
			}
			return;
		}
		tempVis[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6 && block[nx][ny] != 0 && !tempVis[nx][ny]) {
				if (cnt == 0) {
					dfs(nx, ny, cnt + 1, d, fx, fy);
				} else if (pre == d) {
					dfs(nx, ny, cnt + 1, pre, fx, fy);
				} else {
					dfs(nx, ny, cnt, pre, fx, fy);
				}
			}
		}
	}
}
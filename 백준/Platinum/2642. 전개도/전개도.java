import java.io.*;
import java.util.*;

class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };
	static int[][] block, point;
	static boolean vis[][], tempVis[][];
	static int pair, opposite;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
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
			System.out.println(0);
		} else {
			System.out.println(opposite);
		}
	}

	static void dfs(int x, int y, int cnt, int pre, int fx, int fy) {
		if (cnt == 2) {
			if (!vis[fx][fy] && !vis[x][y]) {
				// 카운트가 2개면 짝 성립
				vis[fx][fy] = true;
				vis[x][y] = true;
				pair++;
				if (block[fx][fy] == 1)
					opposite = block[x][y];
				if (block[x][y] == 1)
					opposite = block[fx][fy];
			}
			return;
		}
		tempVis[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6 && block[nx][ny] != 0 && !tempVis[nx][ny]) {
				if (cnt == 0) {
					// 시작 블록이면 방향 등록
					dfs(nx, ny, cnt + 1, d, fx, fy);
				} else if (pre == d) {
					// 같은 방향이면 카운트 +1
					dfs(nx, ny, cnt + 1, pre, fx, fy);
				} else {
					// 다른 방향이면 이동만
					dfs(nx, ny, cnt, pre, fx, fy);
				}
			}
		}
	}
}
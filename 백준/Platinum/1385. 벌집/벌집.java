import java.util.*;
import java.io.*;

class Main {
	static int dx[] = { -1, -1, 0, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 0, -1 };
	static int beeHive[][], prePos[][][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		beeHive = new int[1200][1200];
		prePos = new int[1200][1200][2];
		makeHive();
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < 1200; i++) {
			for (int j = 0; j < 1200; j++) {
				if (beeHive[i][j] == b) {
					prePos[i][j] = new int[] { -1, -1 };
					q.offer(new int[] { i, j });
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			if (beeHive[cur[0]][cur[1]] == a) {
				int x = cur[0];
				int y = cur[1];
				while (true) {
					sb.append(beeHive[x][y] + " ");
					int nx = prePos[x][y][0];
					int ny = prePos[x][y][1];
					if (nx == -1 && ny == -1)
						break;
					x = nx;
					y = ny;
				}
				break;
			}
			for (int d = 0; d < 6; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < 1200 && ny >= 0 && ny < 1200 && prePos[nx][ny][0] == 0 && prePos[nx][ny][1] == 0) {
					prePos[nx][ny][0] = cur[0];
					prePos[nx][ny][1] = cur[1];
					q.offer(new int[] { nx, ny });
				}
			}
		}
		System.out.println(sb);
	}

	static void makeHive() {
		int x = 600, y = 600, w = 0;
		int num = 1;
		beeHive[x][y] = num;
		x += dx[5];
		y += dy[5];
		while (true) {
			for (int d = 0; d < 6; d++) {
				for (int r = 0; r < (d == 0 ? w : w + 1); r++) {
					beeHive[x][y] = ++num;
					if (num == 1000000)
						return;
					int nx = x + dx[d];
					int ny = y + dy[d];
					x = nx;
					y = ny;
				}
			}
			beeHive[x][y] = ++num;
			x += dx[5];
			y += dy[5];
			w++;
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, vis[][], cheese[][], size;
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		vis = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 1;
		while (true) {
			if (bfs(0, 0, time)) {
				time++;
			} else
				break;
		}
		System.out.println(time - 1);
		System.out.println(size);
	}

	static boolean bfs(int x, int y, int time) {
		boolean flag = false;
		ArrayList<int[]> al = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		vis[x][y] = time;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && vis[nx][ny] != time) {
					vis[nx][ny] = time;
					if (cheese[nx][ny] == 1) {
						flag = true;
						al.add(new int[] { nx, ny });
					} else {
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		if (flag) {
			size = al.size();
			for (int[] p : al) {
				cheese[p[0]][p[1]] = 0;
			}
			return true;
		}
		return false;
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int[][] office;
	static boolean[][] cameraCheck;
	static int N, M, ans;
	static ArrayList<Camera> camera;

	static class Camera {
		int x, y, mode;

		public Camera(int x, int y, int mode) {
			this.x = x;
			this.y = y;
			this.mode = mode;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		office = new int[N][M];
		cameraCheck = new boolean[N][M];
		camera = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] > 0 && office[i][j] != 6) {
					cameraCheck[i][j] = true;
					camera.add(new Camera(i, j, office[i][j]));
				}
			}
		}
		solve(0);
		System.out.println(ans);
	}

	static void solve(int cnt) {
		if (cnt == camera.size()) {
			ans = Math.min(ans, count());
			return;
		}
		Camera cur = camera.get(cnt);
		if (cur.mode == 1) {
			for (int i = 0; i < 4; i++) {
				go(cur.x, cur.y, i);
				solve(cnt + 1);
				back(cur.x, cur.y, i);
			}
		} else if (cur.mode == 2) {
			for (int i = 0; i < 2; i++) {
				go(cur.x, cur.y, i);
				go(cur.x, cur.y, (i + 2) % 4);
				solve(cnt + 1);
				back(cur.x, cur.y, i);
				back(cur.x, cur.y, (i + 2) % 4);
			}
		} else if (cur.mode == 3) {
			for (int i = 0; i < 4; i++) {
				go(cur.x, cur.y, i);
				go(cur.x, cur.y, (i + 1) % 4);
				solve(cnt + 1);
				back(cur.x, cur.y, i);
				back(cur.x, cur.y, (i + 1) % 4);
			}
		} else if (cur.mode == 4) {
			for (int i = 0; i < 4; i++) {
				go(cur.x, cur.y, i);
				go(cur.x, cur.y, (i + 1) % 4);
				go(cur.x, cur.y, (i + 2) % 4);
				solve(cnt + 1);
				back(cur.x, cur.y, i);
				back(cur.x, cur.y, (i + 1) % 4);
				back(cur.x, cur.y, (i + 2) % 4);
			}
		} else {
			go(cur.x, cur.y, 0);
			go(cur.x, cur.y, 1);
			go(cur.x, cur.y, 2);
			go(cur.x, cur.y, 3);
			solve(cnt + 1);
			back(cur.x, cur.y, 0);
			back(cur.x, cur.y, 1);
			back(cur.x, cur.y, 2);
			back(cur.x, cur.y, 3);
		}
	}

	static void go(int x, int y, int d) {
		if (!cameraCheck[x][y])
			office[x][y]--;
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx >= 0 && nx < N && ny >= 0 && ny < M && office[nx][ny] != 6) {
			go(nx, ny, d);
		}
	}

	static void back(int x, int y, int d) {
		if (!cameraCheck[x][y])
			office[x][y]++;
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx >= 0 && nx < N && ny >= 0 && ny < M && office[nx][ny] != 6) {
			back(nx, ny, d);
		}
	}

	static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
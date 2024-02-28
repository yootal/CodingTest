import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, M, K, ans;
	static Shark[][] sharkInfo;

	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sharkInfo = new Shark[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			switch (d) {
			case 1:
				d = 0;
				break;
			case 2:
				d = 2;
				break;
			case 3:
				d = 1;
				break;
			case 4:
				d = 3;
				break;
			}
			int z = Integer.parseInt(st.nextToken());
			sharkInfo[x - 1][y - 1] = new Shark(s, d, z);
		}

		ans = 0;
		for (int i = 0; i < M; i++) {
			fishing(i);
			sharkMove();
		}
		System.out.println(ans);
	}

	static void fishing(int col) {
		for (int i = 0; i < N; i++) {
			if (sharkInfo[i][col] != null) {
				ans += sharkInfo[i][col].z;
				sharkInfo[i][col] = null;
				return;
			}
		}
	}

	static void sharkMove() {
		Shark[][] afterMove = new Shark[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sharkInfo[i][j] != null) {
					Shark cur = sharkInfo[i][j];
					int td = cur.d;
					int tx = i;
					int ty = j;
					if (td == 0 || td == 2) {
						int sx = Math.abs(dx[td] * cur.s) % ((N - 1) * 2);
						for (int k = 0; k < sx; k++) {
							if ((tx == 0 && td == 0) || (tx == N - 1 && td == 2)) {
								td += 2;
								td %= 4;
							}
							tx += dx[td];
						}
					} else {
						int sy = Math.abs(dy[td] * cur.s) % ((M - 1) * 2);
						for (int k = 0; k < sy; k++) {
							if ((ty == 0 && td == 3) || (ty == M - 1 && td == 1)) {
								td += 2;
								td %= 4;
							}
							ty += dy[td];
						}
					}
					if (afterMove[tx][ty] == null) {
						afterMove[tx][ty] = new Shark(cur.s, td, cur.z);
					} else {
						if (afterMove[tx][ty].z < cur.z) {
							afterMove[tx][ty] = new Shark(cur.s, td, cur.z);
						}
					}

				}
			}
		}
		sharkInfo = afterMove;
	}
}
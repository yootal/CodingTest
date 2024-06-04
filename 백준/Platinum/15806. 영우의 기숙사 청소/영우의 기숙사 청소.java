import java.io.*;
import java.util.*;

class Main {
	static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int room[][] = new int[N][N];
		int check[][] = new int[K][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			q.offer(new int[] { x, y });
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			check[i][0] = x;
			check[i][1] = y;
		}
		for (int t = 1; t <= T; t++) {
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				int cur[] = q.poll();
				for (int d = 0; d < 8; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (room[nx][ny] == 3)
							continue;
						// 홀
						else if (t % 2 == 1) {
							if (room[nx][ny] == 1)
								continue;
							else if (room[nx][ny] == 2) {
								room[nx][ny] = 3;
								q.offer(new int[] { nx, ny });
								cnt++;
							} else {
								room[nx][ny] = 1;
								q.offer(new int[] { nx, ny });
								cnt++;
							}
						}
						// 짝
						else {
							if (room[nx][ny] == 2)
								continue;
							else if (room[nx][ny] == 1) {
								room[nx][ny] = 3;
								q.offer(new int[] { nx, ny });
								cnt++;
							} else {
								room[nx][ny] = 2;
								q.offer(new int[] { nx, ny });
								cnt++;
							}
						}
					}
				}
			}
			if (cnt == 0)
				break;
			M = cnt;
		}
		boolean ans = false;
		boolean flag = T % 2 == 1 ? true : false;
		for (int i = 0; i < K; i++) {
			int cur[] = check[i];
			if (flag) {
				if (room[cur[0]][cur[1]] == 1 || room[cur[0]][cur[1]] == 3) {
					ans = true;
					break;
				}
			} else {
				if (room[cur[0]][cur[1]] == 2 || room[cur[0]][cur[1]] == 3) {
					ans = true;
					break;
				}
			}
		}
		System.out.println(ans ? "YES" : "NO");
	}
}
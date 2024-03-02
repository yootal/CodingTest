import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, record[][][];
	static Micro board[][];

	static class Micro {
		int s, d;

		public Micro(int s, int d) {
			this.s = s;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		record = new int[100][100][2];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			board = new Micro[N][N];
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
					d = 3;
					break;
				case 4:
					d = 1;
					break;
				}
				board[x][y] = new Micro(s, d);
			}
			for (int i = 0; i < M; i++) {
				move();
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != null)
						ans += board[i][j].s;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void move() {
		Micro[][] board2 = new Micro[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != null) {
					Micro cur = board[i][j];
					int nx = i + dx[cur.d];
					int ny = j + dy[cur.d];
					if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
						cur.d = (cur.d + 2) % 4;
						cur.s /= 2;
						board2[nx][ny] = cur;
					} else if (board2[nx][ny] != null) {
						if (record[nx][ny][0] < cur.s) {
							board2[nx][ny].d = cur.d;
							record[nx][ny][0] = cur.s;
							record[nx][ny][1] = cur.d;
						}
						board2[nx][ny].s += cur.s;
					} else {
						board2[nx][ny] = cur;
						record[nx][ny] = new int[] {cur.s,cur.d};
					}
				}
			}
		}
		board = board2;
	}
}
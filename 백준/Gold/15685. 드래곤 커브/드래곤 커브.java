import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { 0, -1, 0, 1 };
	static final int[] dy = { 1, 0, -1, 0 };
	static int N;
	static int[] record = new int[1024];
	static boolean[][] board;
	static ArrayDeque<Integer> dq;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new boolean[101][101];
		Info[] info = new Info[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			info[i] = new Info(y, x, d, g);
		}
		for (int i = 0; i < N; i++) {
			dq = new ArrayDeque<>();
			dq.offer((info[i].d + 1) % 4);
			board[info[i].x][info[i].y] = true;
			info[i].x += dx[info[i].d];
			info[i].y += dy[info[i].d];
			board[info[i].x][info[i].y] = true;
			dragonCurve(info[i].x, info[i].y, info[i].g);
		}
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				boolean flag = true;
				label: for (int i2 = i; i2 < i + 2; i2++) {
					for (int j2 = j; j2 < j + 2; j2++) {
						if (!board[i2][j2]) {
							flag = false;
							break label;
						}
					}
				}
				if (flag)
					ans++;
			}
		}
		System.out.println(ans);
	}

	static void dragonCurve(int x, int y, int repeat) {
		if (repeat == 0)
			return;
		int idx = 0;
		for (int d : dq) {
			x += dx[d];
			y += dy[d];
			board[x][y] = true;
			record[idx++] = (d + 1) % 4;
		}
		for (int i = 0; i < idx; i++) {
			dq.offerFirst(record[i]);
		}
		dragonCurve(x, y, repeat - 1);
	}

	static class Info {
		int x, y, d, g;

		public Info(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}
}
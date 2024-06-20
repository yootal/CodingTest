import java.io.*;
import java.util.*;

class Main {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(br.readLine());
		if (find > R * C) {
			System.out.println(0);
			System.exit(0);
		}
		int board[][] = new int[R][C];
		int x = R - 1, y = 0, d = 0;
		for (int i = 1; i <= R * C; i++) {
			board[x][y] = i;
			if (i == find) {
				System.out.println((y + 1) + " " + Math.abs(R - x));
				break;
			}
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || board[nx][ny] != 0) {
				d++;
				d %= 4;
				nx = x + dx[d];
				ny = y + dy[d];
			}
			x = nx;
			y = ny;
		}
	}
}
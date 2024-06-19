import java.io.*;
import java.util.*;

class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };
	static int N, M;
	static ArrayList<int[]> al;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();
		char board[][] = new char[N][M];
		boolean vis[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == '.')
					vis[i][j] = true;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == '*')
					crossCheck(vis, board, i, j);
			}
		}
		if (al.size() > 0 && visCheck(vis)) {
			StringBuilder sb = new StringBuilder();
			sb.append(al.size() + "\n");
			for (int[] row : al) {
				for (int v : row) {
					sb.append(v + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		} else
			System.out.println(-1);
	}

	static void crossCheck(boolean vis[][], char board[][], int x, int y) {
		int w = 1;
		while (x + w < N && x - w >= 0 && y + w < M && y - w >= 0) {
			boolean flag = false;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d] * w;
				int ny = y + dy[d] * w;
				if (board[nx][ny] != '*') {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d] * w;
				int ny = y + dy[d] * w;
				vis[nx][ny] = true;
			}
			vis[x][y] = true;
			w++;
		}
		if (w > 1)
			al.add(new int[] { x + 1, y + 1, w - 1 });
	}

	static boolean visCheck(boolean vis[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!vis[i][j])
					return false;
			}
		}
		return true;
	}
}
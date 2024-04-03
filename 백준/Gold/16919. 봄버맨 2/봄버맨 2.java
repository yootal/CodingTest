import java.io.*;
import java.util.*;

public class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int board[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				if (row.charAt(j) == 'O') {
					board[i][j] = 0;
				} else {
					board[i][j] = -1;
				}

			}
		}
		if (T > 4) {
			T = (T % 4) + 4;
		}
		int time = 1;
		while (time <= T) {

			// 시간 흐름
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] != -1)
						board[i][j]++;
				}
			}

			// 빈공간에 설치
			if (time > 1) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (board[i][j] == -1)
							board[i][j] = 0;
					}
				}
			}

			// 터뜨리기
			ArrayList<int[]> temp = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 3) {
						temp.add(new int[] { i, j });
					}
				}
			}
			for (int[] p : temp) {
				int x = p[0];
				int y = p[1];
				board[x][y] = -1;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
						board[nx][ny] = -1;
					}
				}
			}
			time++;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[i][j] == -1 ? '.' : 'O');
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
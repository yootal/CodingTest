import java.io.*;
import java.util.*;

public class Main {
	static int[][] board = new int[19][19];
	static final int[] dx = { 0, 1, 1, 1 };
	static final int[] dy = { 1, 1, 0, -1 };
	static boolean[][][] vis = new boolean[19][19][4];
	static boolean dcheck;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("Test5.txt"));
		// 여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean check = false;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == 1 || board[i][j] == 2) {
					if (counting(i, j)) {
						check = true;
						System.out.println(board[i][j]);
						if (dcheck) {
							System.out.println((i + 1 + 4) + " " + (j + 1 - 4));
						} else {
							System.out.println((i + 1) + " " + (j + 1));
						}
						break;
					}

				}
			}
			if (check) {
				break;
			}
		}
		if (!check) {
			System.out.println(0);
		}

	}

	static boolean counting(int i, int j) {
		int flag = board[i][j];
		for (int d = 0; d < 4; d++) {
			if (vis[i][j][d]) {
				continue;
			}
			int cnt = 1;
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[d];
				ny += dy[d];
				if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
					if (board[nx][ny] == flag) {
						cnt++;
					} else
						break;
				} else
					break;
			}
			if (cnt == 5) {
				if (d == 3) {
					dcheck = true;
				}
				return true;
			} else if (cnt > 5) {
				int nx2 = i;
				int ny2 = j;
				for (int k = 0; k < cnt; k++) {
					vis[nx2][ny2][d] = true;
					nx2 += dx[d];
					ny2 += dy[d];
				}
			}
		}
		return false;
	}
}
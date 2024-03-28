import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] board = new int[n + 1][n + 1];
		int[][] next = new int[n + 1][n + 1];

		// 초기화
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(board[i], 200000);
			board[i][i] = 0;
			Arrays.fill(next[i], -1);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (board[a][b] > c)
				board[a][b] = c;
			next[a][b] = b;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}

		// 최소 비용
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(board[i][j] == 200000 ? 0 : board[i][j]).append(" ");
			}
			sb.append("\n");
		}

		// 경로 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (board[i][j] == 0 || board[i][j] == 200000) {
					sb.append(0 + "\n");
					continue;
				}
				int cnt = 1;
				ArrayList<Integer> path = new ArrayList<>();
				int cur = i;
				while (cur != j) {
					path.add(cur);
					cnt++;
					cur = next[cur][j];
				}
				sb.append(cnt + " ");
				for (int x : path) {
					sb.append(x + " ");
				}
				sb.append(cur + "\n");
			}
		}
		System.out.print(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		int[][][] dp = new int[N][N][3]; // 0: 가로, 1: 대각, 2: 세로

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		dp[0][0][0] = 1;
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {

				if (board[i][j] == 1)
					continue; // 벽이면 넘어감

				// 가로 = 가로나 대각에서 연결
				dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];

				if (i == 0)
					continue; // 0-1은 불가능

				// 세로 = 세로나 대각에서 연결
				dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2];

				// 대각 = 가로, 세로, 대각에서 연결
				if (board[i - 1][j] == 1 || board[i][j - 1] == 1)
					continue; // 벽을 스치면 안된다.
				dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}
}
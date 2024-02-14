import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] board;
	static int ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
			}
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			if (pipe(i, 0))
				ans++;
		}
		System.out.println(ans);
	}

	static boolean pipe(int x, int y) {
		board[x][y] = '-';
		if (y == M - 1) {
			return true;
		}
		if (x > 0 && board[x - 1][y + 1] == '.')
			if (pipe(x - 1, y + 1))
				return true;
		if (board[x][y + 1] == '.')
			if (pipe(x, y + 1))
				return true;
		if (x < N - 1 && board[x + 1][y + 1] == '.')
			if (pipe(x + 1, y + 1))
				return true;
		return false;
	}
}
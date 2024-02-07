import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static char board[][];
	static int[] st = new int[2];
	static boolean ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		board = new char[100][100];
		for (int tc = 1; tc < 11; tc++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				String row = br.readLine();
				for (int j = 0; j < 100; j++) {
					char c = row.charAt(j);
					board[i][j] = c;
					if (c == '2') {
						st[0] = i;
						st[1] = i;
					}
				}
			}
			ans = false;
			dfs(st[0], st[1]);
			sb.append("#").append(n).append(" ").append(ans ? 1 : 0).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int x, int y) {
		if (board[x][y] == '3') {
			ans = true;
			return;
		}
		board[x][y] = '1';
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && board[nx][ny] != '1') {
				dfs(nx, ny);
			}
		}
	}
}
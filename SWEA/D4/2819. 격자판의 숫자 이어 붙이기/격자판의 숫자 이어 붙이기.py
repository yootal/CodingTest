import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static String num[], board[][];
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			set.clear();
			board = new String[4][4];
			num = new String[7];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					board[i][j] = st.nextToken();
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(new int[] { i, j }, 0);
				}
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int[] p, int cnt) {
		if (cnt == 7) {
			String x = String.join("", num);
			set.add(x);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = p[0] + dx[d];
			int ny = p[1] + dy[d];
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				num[cnt] = board[nx][ny];
				dfs(new int[] { nx, ny }, cnt + 1);
			}
		}
	}
}
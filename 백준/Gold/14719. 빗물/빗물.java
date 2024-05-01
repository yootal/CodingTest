import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int board[][] = new int[n][m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int h = Integer.parseInt(st.nextToken());
			for (int j = n - 1; j >= n - h; j--) {
				board[j][i] = 1;
			}
		}
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			int p = -1;
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					if (p == -1) {
					} else {
						ans += (j - p - 1);
					}
					p = j;
				}
			}
		}
		System.out.println(ans);
	}
}
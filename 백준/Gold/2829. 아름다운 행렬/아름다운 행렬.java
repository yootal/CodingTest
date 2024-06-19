import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		int prefix[][][] = new int[N + 2][N + 2][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				prefix[i][j][0] = prefix[i - 1][j - 1][0] + num;
				prefix[i][j][1] = prefix[i - 1][j + 1][1] + num;
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= N - i + 1; j++) {
				for (int k = 1; k <= N - i + 1; k++) {
					int cur = (prefix[j + i - 1][k + i - 1][0] - prefix[j - 1][k - 1][0])
							- (prefix[j + i - 1][k][1] - prefix[j - 1][k + i][1]);
					ans = Math.max(ans, cur);
				}
			}
		}
		System.out.println(ans);
	}
}
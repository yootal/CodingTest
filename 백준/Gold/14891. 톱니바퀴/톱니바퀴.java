import java.io.*;
import java.util.*;

public class Main {
	static int K, ans;
	static char[][] wheel;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		wheel = new char[4][8];
		for (int i = 0; i < 4; i++) {
			String row = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = row.charAt(j);
			}
		}
		int ans = 0;
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			solve(x - 1, d, 0);
		}
		for (int j = 0; j < 4; j++) {
			if (wheel[j][0] == '1') {
				ans += 1 << j;
			}
		}
		System.out.print(ans);
	}

	static void solve(int num, int d, int flag) {
		if ((flag == 0 || flag == -1) && num > 0) {
			if (wheel[num][6] != wheel[num - 1][2]) {
				solve(num - 1, -d, -1);
			}
		}
		if ((flag == 0 || flag == 1) && num < 3) {
			if (wheel[num][2] != wheel[num + 1][6]) {
				solve(num + 1, -d, 1);
			}
		}
		rotate(num, d);

	}

	static void rotate(int num, int d) {
		if (d == 1) {
			char temp = wheel[num][7];
			for (int i = 7; i > 0; i--) {
				wheel[num][i] = wheel[num][i - 1];
			}
			wheel[num][0] = temp;
		} else {
			char temp = wheel[num][0];
			for (int i = 0; i < 7; i++) {
				wheel[num][i] = wheel[num][i + 1];
			}
			wheel[num][7] = temp;
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		System.out.print(sb);
	}

	static void dfs(int x, int cnt) {
		if (cnt == n) {
			sb.append(x).append("\n");
			return;
		}
		for (int i = 1; i < 10; i += 2) {
			int nxt = x * 10 + i;
			if (check(nxt)) {
				dfs(nxt, cnt + 1);
			}
		}
	}

	static boolean check(int x) {
		for (int j = 2; j <= x / 2; j++) {
			if (x % j == 0)
				return false;
		}
		return true;
	}
}
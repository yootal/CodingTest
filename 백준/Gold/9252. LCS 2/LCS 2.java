import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		String b = br.readLine();
		int dp[][] = new int[a.length() + 1][b.length() + 1];
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				char ac = a.charAt(i - 1);
				char bc = b.charAt(j - 1);
				if (ac == bc) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		Stack<Character> st = new Stack<>();
		int i = a.length();
		int j = b.length();
		System.out.println(dp[i][j]);
		while (i > 0 && j > 0) {
			if (i == 0 || j == 0)
				break;
			if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else {
				st.push(a.charAt(i - 1));
				i--;
				j--;
			}

		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.print(sb);
	}
}
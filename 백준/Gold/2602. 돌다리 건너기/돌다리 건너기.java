import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String seq = br.readLine();
		String devil = br.readLine();
		String angel = br.readLine();
		char s[] = seq.toCharArray();
		char d[] = devil.toCharArray();
		char a[] = angel.toCharArray();
		int dp[][][] = new int[d.length][seq.length()][2];
		for (int j = 0; j < d.length; j++) {
			if (d[j] == s[0])
				dp[j][0][0]++;
			if (a[j] == s[0])
				dp[j][0][1]++;
		}
		for (int i = 1; i < seq.length(); i++) {
			for (int j = 0; j < d.length; j++) {
				if (d[j] == s[i]) {
					for (int k = 0; k < j; k++) {
						if (a[k] == s[i - 1]) {
							dp[j][i][0] += dp[k][i - 1][1];
						}
					}
				}
				if (a[j] == s[i]) {
					for (int k = 0; k < j; k++) {
						if (d[k] == s[i - 1]) {
							dp[j][i][1] += dp[k][i - 1][0];
						}
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < d.length; i++) {
			ans += dp[i][seq.length() - 1][0];
			ans += dp[i][seq.length() - 1][1];
		}
		System.out.println(ans);
	}
}
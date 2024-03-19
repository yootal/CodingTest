import java.io.*;
import java.util.*;

public class Main {
	static final long mod = 1000000007;
	static long[] score;
	static long ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		score = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			score[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(score);
		ans = 0;
		for (int i = 0; i < n; i++) {
			ans += (score[i] % mod) * ((getGap(i) - getGap(n - i - 1)) % mod);
			ans %= mod;
		}
		System.out.println(ans);
	}

	static long getGap(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 2;
		long half = getGap(n / 2);
		if (n % 2 == 1)
			return half * half * 2 % mod;
		else
			return half * half % mod;
	}
}
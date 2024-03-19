import java.io.*;
import java.util.*;

public class Main {
	static final long mod = 1000000007;
	static long[] score;
	static long[] gap;
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
		gap = new long[n];
		gap[0] = 1;
		for (int i = 0; i < n - 1; i++) {
			gap[i + 1] = (gap[i] * 2) % mod;
		}
		Arrays.sort(score);
		ans = 0;
		for (int i = 0; i < n; i++) {
			ans += (score[i]) * (gap[i] - gap[n - i - 1]);
			ans %= mod;
		}
		System.out.println(ans);
	}
}
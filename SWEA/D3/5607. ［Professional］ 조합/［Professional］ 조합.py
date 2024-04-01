import java.io.*;
import java.util.*;

public class Solution {
	static long mod = 1234567891;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			long top = factorial(N);
			long bottom = (factorial(N - R) % mod) * (factorial(R) % mod) % mod;
			sb.append("#").append(tc + " ").append((top % mod) * (modDivision(bottom, mod - 2) % mod) % mod)
					.append("\n");
		}
		System.out.print(sb);
	}

	static long factorial(long num) {
		long n = 1;
		for (int i = 2; i <= num; i++) {
			n *= i;
			n %= mod;
		}
		return n;
	}

	static long modDivision(long n, long r) {
		if (r == 0)
			return 1;
		else if (r == 1) {
			return n;
		}
		long temp = modDivision(n, r / 2);
		if (r % 2 == 1) {
			return ((temp * temp % mod) * n % mod) % mod;
		} else {
			return temp * temp % mod;
		}
	}
}
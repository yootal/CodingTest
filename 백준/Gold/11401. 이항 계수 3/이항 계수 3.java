import java.io.*;
import java.util.*;

public class Main {
	static long mod = 1000000007;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long[] facto = new long[4000001];
		facto[0] = 1;
		for (int i = 1; i < 4000001; i++) {
			facto[i] = facto[i - 1] * i % mod;
		}
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long top = facto[N];
		long bottom = facto[N - R] * facto[R] % mod;
		System.out.println(top * power(bottom, mod - 2) % mod);
	}

	static long power(long n, long k) { // N^K
		long res = 1L;
		n %= mod;
		while (k > 0) {
			if (k % 2 == 1) {
				res *= n;
				res %= mod;
			}
			k >>= 1;
			n *= n;
			n %= mod;
		}
		return res;
	}
}
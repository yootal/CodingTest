import java.io.*;
import java.util.*;

class Main {
	static long ans, pDp[], rDp[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken());
		pDp = new long[51];
		rDp = new long[51];
		pDp[0] = 1;
		rDp[0] = 1;
		for (int i = 1; i < 51; i++) {
			pDp[i] = pDp[i - 1] * 2 + 1;
			rDp[i] = rDp[i - 1] * 2 + 3;
		}
		makeBurger(n, 1, rDp[n], x);
		System.out.println(ans);
	}

	static void makeBurger(int l, long s, long e, long x) {
		if (l == 0) {
			if (e <= x)
				ans++;
			return;
		}
		if (e <= x) {
			ans += pDp[l];
			return;
		}
		long mid = (s + e) / 2;
		makeBurger(l - 1, s + 1, mid - 1, x);
		if (mid <= x)
			ans++;
		if (mid + 1 <= x)
			makeBurger(l - 1, mid + 1, e - 1, x);
	}
}
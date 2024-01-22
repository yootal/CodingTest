import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		long l = 1;
		long r = k;
		long ans = 0;
		while (l <= r) {
			long m = (l + r) / 2;
			long cnt = 0;
			for (int i = 1; i <= n; i++) {
				cnt += Math.min(m / i, n);
			}
			if (cnt < k) {
				l = m + 1;
			} else {
				ans = m;
				r = m - 1;
			}
		}
		System.out.println(ans);
	}
}
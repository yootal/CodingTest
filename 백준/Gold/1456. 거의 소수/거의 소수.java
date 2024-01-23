import java.io.*;
import java.util.*;

public class Main {
	static long A;
	static long B;
	static final int limit = 10000000;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		boolean[] num = new boolean[limit + 1];
		for (int i = 2; i <= Math.sqrt(limit + 1); i++) {
			if (!num[i]) {
				for (int j = i * i; j <= limit; j += i) {
					num[j] = true;
				}
			}
		}
		int ans = 0;
		for (int i = 2; i <= limit; i++) {
			if (!num[i]) {
				long cur = i;
				while ((double) i <= (double) B / (double)cur) {
					if ((double) i >= (double) A / (double)cur) {
						ans++;
					}
					cur *= i;
				}
			}
		}
		System.out.println(ans);
	}
}
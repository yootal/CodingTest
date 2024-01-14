import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long[] prefix_sum;
	static long[] mod_count;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long ans = 0;
		prefix_sum = new long[N + 1];
		mod_count = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			n = Integer.parseInt(st.nextToken());
			prefix_sum[i] = prefix_sum[i - 1] + n;

		}
		for (int i = 0; i < N; i++) {
			int record = (int) (prefix_sum[i + 1] % M);
			if (record == 0)
				ans++;
			mod_count[record]++;
		}
		for (int i = 0; i < M; i++) {
			if (mod_count[i] > 1) {
				ans += (mod_count[i] * (mod_count[i] - 1) / 2);
			}
		}

		System.out.println(ans);
	}

}
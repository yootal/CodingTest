import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] num;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		solve(num[0], 1, a, b, c, d);
		System.out.printf("%d\n%d", max, min);
	}

	static void solve(int total, int cnt, int a, int b, int c, int d) {
		if (cnt == n) {
			max = Math.max(total, max);
			min = Math.min(total, min);
			return;
		}
		if (a > 0) {
			solve(total + num[cnt], cnt + 1, a - 1, b, c, d);
		}
		if (b > 0) {
			solve(total - num[cnt], cnt + 1, a, b - 1, c, d);
		}
		if (c > 0) {
			solve(total * num[cnt], cnt + 1, a, b, c - 1, d);
		}
		if (d > 0) {
			solve(total / num[cnt], cnt + 1, a, b, c, d - 1);
		}

	}

}
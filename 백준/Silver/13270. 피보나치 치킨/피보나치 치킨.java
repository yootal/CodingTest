import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int fibo[] = new int[5000];
		int n = Integer.parseInt(br.readLine());
		fibo[1] = 1;
		for (int i = 2; i < 5000; i++) {
			fibo[i] = fibo[i - 2] + fibo[i - 1];
		}
		int minDp[] = new int[n + 1];
		int maxDp[] = new int[n + 1];
		minDp[2] = 1;
		maxDp[2] = 1;
		if (n > 2) {
			minDp[3] = 2;
			maxDp[3] = 2;
		}
		for (int i = 4; i <= n; i++) {
			minDp[i] = Integer.MAX_VALUE;
			maxDp[i] = Integer.MIN_VALUE;
			for (int j = 3; j < 5000; j++) {
				if (fibo[j] > i)
					break;
				minDp[i] = Math.min(minDp[i], minDp[i - fibo[j]] + fibo[j - 1]);
				maxDp[i] = Math.max(maxDp[i], maxDp[i - fibo[j]] + fibo[j - 1]);
			}
		}
		System.out.println(minDp[n] + " " + maxDp[n]);
	}
}
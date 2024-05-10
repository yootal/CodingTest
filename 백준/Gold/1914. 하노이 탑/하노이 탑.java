import java.io.*;
import java.math.BigInteger;

class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		BigInteger dp[] = new BigInteger[N + 1];
		dp[1] = BigInteger.ONE;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
		}
		System.out.println(dp[N]);
		if (N <= 20) {
			hanoi(N, 1, 3);
			System.out.println(sb);
		}
	}

	static void hanoi(int n, int a, int b) {
		if (n > 1)
			hanoi(n - 1, a, 6 - a - b);
		if (N <= 20)
			sb.append(a + " " + b + "\n");
		if (n > 1)
			hanoi(n - 1, 6 - a - b, b);
	}
}
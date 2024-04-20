import java.io.*;
import java.util.*;

public class Main {
	static int N, dp[][];
	static Matrix m[];

	static class Matrix {
		int x, y;

		public Matrix(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		m = new Matrix[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			m[i] = new Matrix(x, y);
		}
		dp = new int[N + 1][N + 1];
		System.out.println(calc(1, N));
	}

	// TopDown 재귀
	static int calc(int s, int e) {
		if (dp[s][e] != 0)
			return dp[s][e];
		if (s == e)
			return 0;
		if (s + 1 == e)
			return m[s].x * m[s].y * m[e].y;
		int temp = Integer.MAX_VALUE;
		for (int i = s; i < e; i++) {
			temp = Math.min(temp, m[s].x * m[i].y * m[e].y + calc(s, i) + calc(i + 1, e));
		}
		return dp[s][e] = temp;
	}
}
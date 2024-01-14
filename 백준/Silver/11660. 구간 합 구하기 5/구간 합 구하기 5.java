import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int a;
	static int b;
	static int c;
	static int d;
	static int[][] prefix_sum;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		prefix_sum = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				n = Integer.parseInt(st.nextToken());
				prefix_sum[i][j] = prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1] + n;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			sb.append(prefix_sum[c][d] - prefix_sum[a - 1][d] - prefix_sum[c][b - 1] + prefix_sum[a - 1][b - 1])
					.append("\n");
		}
		System.out.println(sb);
	}

}
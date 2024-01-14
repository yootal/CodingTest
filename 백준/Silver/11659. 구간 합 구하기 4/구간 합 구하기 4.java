import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int a;
	static int b;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		int[] prefix_sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			num[i] = n;
			prefix_sum[i + 1] = prefix_sum[i] + n;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(prefix_sum[b] - prefix_sum[a - 1]).append("\n");
		}
		System.out.println(sb);
	}

}
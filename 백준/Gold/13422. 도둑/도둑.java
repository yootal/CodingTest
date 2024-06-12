import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int value[] = new int[N * 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				value[i] = Integer.parseInt(st.nextToken());
				value[N + i] = value[i];
			}
			int e = 0;
			int scope = 0;
			int sum = 0;
			int ans = 0;
			for (int s = 0; s < N; s++) {
				while (scope < M) {
					sum += value[e];
					e++;
					scope++;
				}
				if (sum < K)
					ans++;
				if (N == M)
					break;
				sum -= value[s];
				scope--;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
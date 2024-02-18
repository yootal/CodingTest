import java.io.*;
import java.util.*;

public class Solution {
	static int N, arr[][], vis[], upCnt, downCnt, num;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];
			vis = new int[N + 1];
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// a < b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				upCnt = 0;
				downCnt = 0;
				num = i;
				countUp(i);
				num = -i;
				countDown(i);
				if (upCnt + downCnt == N - 1)
					ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void countUp(int x) {
		vis[x] = num;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (vis[i] != num && arr[i][cur] == 1) {
					vis[i] = num;
					q.offer(i);
					upCnt++;
				}
			}
		}
	}

	static void countDown(int x) {
		vis[x] = num;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (vis[i] != num && arr[cur][i] == 1) {
					vis[i] = num;
					q.offer(i);
					downCnt++;
				}
			}
		}
	}
}
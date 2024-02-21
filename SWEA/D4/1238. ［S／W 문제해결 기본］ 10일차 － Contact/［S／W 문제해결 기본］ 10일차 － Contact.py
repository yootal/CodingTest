import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean[][] arr;
		boolean[] vis;
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			arr = new boolean[101][101];
			vis = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = true;
			}
			int depth = 0;
			int ans = 0;
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { S, 0 });
			vis[S] = true;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				if (depth < cur[1]) {
					depth = cur[1];
					ans = 0;
				}
				if (depth == cur[1]) {
					ans = Math.max(ans, cur[0]);
				}
				for (int i = 1; i < 101; i++) {
					if (!vis[i] && arr[cur[0]][i]) {
						vis[i] = true;
						q.offer(new int[] { i, cur[1] + 1 });
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans;
	static boolean v[];
	static Point start, end, points[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N];
			v = new boolean[N];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			dfs(0, start, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int total, Point last, int cnt) {
		if (total > ans)
			return;
		if (cnt == N) {
			ans = Math.min(ans, total + calcDist(last, end));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				dfs(total + calcDist(last, points[i]), points[i], cnt + 1);
				v[i] = false;
			}
		}
	}

	static int calcDist(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
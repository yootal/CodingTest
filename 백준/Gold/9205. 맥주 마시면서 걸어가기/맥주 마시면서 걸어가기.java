import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			Point[] stores = new Point[n + 1];
			boolean[] vis = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				stores[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			Point festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			stores[n] = festival;
			ArrayDeque<Point> q = new ArrayDeque<>();
			q.offer(home);
			boolean ans = false;
			while (!q.isEmpty()) {
				Point cur = q.poll();
				for (int i = 0; i <= n; i++) {
					if (!vis[i] && calcDist(cur, stores[i]) <= 1000) {
						vis[i] = true;
						if (vis[n]) {
							ans = true;
							break;
						}
						q.offer(stores[i]);
					}
				}
			}
			sb.append(ans ? "happy" : "sad").append("\n");
		}
		System.out.print(sb);
	}

	static int calcDist(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
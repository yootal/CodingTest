import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans, where[], map[][], times[][];
	static boolean[] v;
	static ArrayList<Point> points;
	static Queue<Person> stairs1;
	static Queue<Person> stairs2;
	static Point[] stairsPoint;

	static class Point {
		int x, y, t;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

	}

	static class Person {
		int t;

		public Person(int t) {
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		stairs1 = new ArrayDeque<>();
		stairs2 = new ArrayDeque<>();
		points = new ArrayList<>();
		stairsPoint = new Point[2];
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			points.clear();
			
			int sIdx = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						points.add(new Point(i, j));
					else if (map[i][j] != 0) {
						stairsPoint[sIdx++] = new Point(i, j, map[i][j]);
					}
				}
			}

			times = new int[2][points.size()];
			for (int i = 0; i < points.size(); i++) {
				times[0][i] = calcTime(stairsPoint[0], points.get(i)) + 1;
				times[1][i] = calcTime(stairsPoint[1], points.get(i)) + 1;
			}

			where = new int[points.size()];
			ans = Integer.MAX_VALUE;
			dfs(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int calcTime(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	static void dfs(int idx) {
		if (idx == points.size()) {
			v = new boolean[points.size()];
			for (int i = 0; i < points.size(); i++) {
				points.get(i).t = times[where[i]][i];
			}
			int checkCnt = 0;
			int time = 0;
			while (true) {
				for (Person p : stairs1) {
					p.t++;
				}
				for (Person p : stairs2) {
					p.t++;
				}
				while (!stairs1.isEmpty() && stairs1.peek().t == stairsPoint[0].t) {
					stairs1.poll();
					checkCnt++;
				}
				while (!stairs2.isEmpty() && stairs2.peek().t == stairsPoint[1].t) {
					stairs2.poll();
					checkCnt++;
				}
				for (int i = 0; i < points.size(); i++) {
					if (v[i])
						continue;
					Point p = points.get(i);
					p.t--;
					if (p.t <= 0 && !v[i]) {
						if (where[i] == 0 && stairs1.size() < 3) {
							stairs1.offer(new Person(0));
							v[i] = true;
						} else if (where[i] == 1 && stairs2.size() < 3) {
							stairs2.offer(new Person(0));
							v[i] = true;
						}
					}
				}
				time++;
				if (checkCnt == points.size())
					break;
			}
			ans = Math.min(ans, time);
			return;
		}
		where[idx] = 1;
		dfs(idx + 1);
		where[idx] = 0;
		dfs(idx + 1);
	}
}
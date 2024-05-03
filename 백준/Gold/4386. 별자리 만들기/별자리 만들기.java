import java.io.*;
import java.util.*;

class Main {
	static class Star {
		double x, y;

		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Star stars[] = new Star[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}
		double dists[][] = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				dists[i][j] = calcDist(stars[i], stars[j]);
			}
		}
		boolean vis[] = new boolean[N];
		double ans = 0;
		PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]));
		pq.offer(new double[] { 0, 0.0 });
		while (!pq.isEmpty()) {
			double[] cur = pq.poll();
			if (vis[(int) cur[0]])
				continue;
			vis[(int) cur[0]] = true;
			ans += cur[1];
			for (int i = 0; i < N; i++) {
				if (!vis[i] && dists[(int) cur[0]][i] != 0) {
					pq.offer(new double[] { i, dists[(int) cur[0]][i] });
				}
			}
		}
		System.out.println(ans);
	}

	static double calcDist(Star s1, Star s2) {
		return Math.sqrt(Math.pow(s2.x - s1.x, 2) + Math.pow(s2.y - s1.y, 2));
	}
}
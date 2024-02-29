import java.io.*;
import java.util.*;

public class Main {
	static int N, points[][];
	static double cost[][], dp[][], INF = 10000;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		cost = new double[N][N];
		points = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			points[i] = new int[] { a, b };
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double dist = calcDist(points[i], points[j]);
				cost[i][j] = dist;
				cost[j][i] = dist;
			}
		}
		dp = new double[N][1 << N];
		System.out.println(tsp(0, 1));
	}

	static double tsp(int cur, int flag) {
		if (flag == (1 << N) - 1) {
			return cost[cur][0];
		}

		if (dp[cur][flag] != 0)
			return dp[cur][flag];

		double minCost = INF;
		for (int nxt = 1; nxt < N; nxt++) {
			if (cost[cur][nxt] == 0 || (flag & (1 << nxt)) != 0)
				continue;
			minCost = Math.min(minCost, tsp(nxt, flag | (1 << nxt)) + cost[cur][nxt]);
		}
		dp[cur][flag] = minCost;
		return minCost;
	}

	static double calcDist(int[] p1, int[] p2) {
		return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
	}
}
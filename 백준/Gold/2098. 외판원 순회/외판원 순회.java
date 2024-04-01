import java.io.*;
import java.util.*;

public class Main {
	static int N, cost[][], dp[][], INF = 10000000;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][1 << N];
		System.out.println(TSP(0, 1 << 0));
	}

	static int TSP(int cur, int flag) {
		if (flag == (1 << N) - 1) {
			if (cost[cur][0] != 0)
				return cost[cur][0];
			else
				return INF;
		}
		if (dp[cur][flag] != 0)
			return dp[cur][flag];
		int minDist = INF;
		for (int nxt = 1; nxt < N; nxt++) {
			if (cost[cur][nxt] == 0)
				continue;
			if ((flag & (1 << nxt)) == 0) { 
				minDist = Math.min(minDist, cost[cur][nxt] + TSP(nxt, flag | (1 << nxt)));
			}
		}
		dp[cur][flag] = minDist;
		return minDist;
	}
}
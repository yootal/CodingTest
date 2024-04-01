import java.io.*;
import java.util.*;

public class Main {
	static int N, cost[][], dp[][], INF = 10000000;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][1 << N];
		// 현재 = cur, 방문 현황 = flag, 방문하지 않은 모든 도시를 거치는 최소 비용
		// dp[cur][visited] = min(dp[cur][visited], dp[next][visited | (1 << next)] + graph[cur][next])
		System.out.println(tsp(0, 1));
	}

	static int tsp(int cur, int flag) {
		if (flag == (1 << N) - 1) { // 다시 출발도시로 갈 수 있는지 확인
			if (cost[cur][0] != 0)
				return cost[cur][0];
			else
				return INF;
		}

		if (dp[cur][flag] != 0) // 이미 계산된 값이면 리턴
			return dp[cur][flag];

		int minCost = INF;
		for (int nxt = 1; nxt < N; nxt++) {
			if (cost[cur][nxt] == 0 || (flag & (1 << nxt)) != 0)
				continue;
			minCost = Math.min(minCost, tsp(nxt, flag | (1 << nxt)) + cost[cur][nxt]);
		}
		dp[cur][flag] = minCost;
		return minCost;
	}
}
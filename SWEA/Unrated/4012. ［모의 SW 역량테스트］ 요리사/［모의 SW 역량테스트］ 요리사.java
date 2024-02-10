import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] synergy;
	static int[] member = new int[2];
	static int ans;
	static boolean[] team;
	static int team1;
	static int team2;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			team = new boolean[N];
			synergy = new int[N][N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			makeTeam(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void makeTeam(int cnt, int start) {
		if (cnt == N / 2) {
			team1 = 0;
			team2 = 0;
			comb(0, 0, true);
			comb(0, 0, false);
			ans = Math.min(ans, Math.abs(team1 - team2));
			return;
		}
		for (int i = start; i < N; i++) {
			team[i] = true;
			makeTeam(cnt + 1, i + 1);
			team[i] = false;
		}
	}

	static void comb(int cnt, int start, boolean check) {
		if (cnt == 2) {
			if (check) {
				team1 += synergy[member[0]][member[1]] + synergy[member[1]][member[0]];
			} else {
				team2 += synergy[member[0]][member[1]] + synergy[member[1]][member[0]];
			}
			return;
		}
		for (int i = start; i < N; i++) {
			if (team[i] != check)
				continue;
			member[cnt] = i;
			comb(cnt + 1, i + 1, check);
		}

	}

}
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D;
	static int map[][];
	static int ans = 0;
	static int[] archer = new int[3];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}

	static int calc_dist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

	static boolean check(int[][] game_map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (game_map[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	static void comb(int cnt, int idx) {
		if (cnt == 3) {
			game();
			return;
		}
		for (int i = idx; i < M; i++) {
			archer[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static void game() {
		int[][] game_map = new int[N][M];
		int ans_cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				game_map[i][j] = map[i][j];
			}
		}
		while (true) {

			// 궁수
			int[] min_dist = new int[3];
			int[][] min_position = new int[3][2];
			Arrays.fill(min_dist, Integer.MAX_VALUE);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (game_map[i][j] == 1) {
						for (int k = 0; k < 3; k++) {
							int dist = calc_dist(new int[] { i, j }, new int[] { N, archer[k] });
							if (dist <= D) {
								if (min_dist[k] > dist) {
									min_dist[k] = dist;
									min_position[k] = new int[] { i, j };
								}
								else if(min_dist[k] == dist) {
									if (min_position[k][1] > j) {
										min_position[k] = new int[] { i, j };
									}
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				if(min_dist[i] == Integer.MAX_VALUE)
					continue;
				if (game_map[min_position[i][0]][min_position[i][1]] == 1) {
					game_map[min_position[i][0]][min_position[i][1]] = 0;
					ans_cnt++;
				}
			}

			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (i == N - 1) {
						game_map[i][j] = 0;
					} else {
						if (game_map[i][j] == 1) {
							game_map[i][j] = 0;
							game_map[i + 1][j] = 1;
						}
					}
				}
			}
//			if (ans_cnt == 9) {
//				for(int[] row : game_map) {
//					System.out.println(Arrays.toString(row));
//				}
//				System.out.println();
//			}
			if(check(game_map)) break;
		}
		ans = Math.max(ans, ans_cnt);

	}
}
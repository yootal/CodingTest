import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int[][] room;
	static int[][] roomAfterSpread;
	static int[] airCleaner = new int[2];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					if (airCleaner[0] == 0)
						airCleaner[0] = i;
					else
						airCleaner[1] = i;
				}
			}
		}

		while (T-- > 0) {
			// 1. 확산
			roomAfterSpread = new int[R][C];
			roomAfterSpread[airCleaner[0]][0] = -1;
			roomAfterSpread[airCleaner[1]][0] = -1;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (room[i][j] == -1)
						continue;
					int cnt = 0;
					int spread = room[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && room[nx][ny] != -1) {
							cnt++;
							roomAfterSpread[nx][ny] += spread;
						}
					}
					roomAfterSpread[i][j] += room[i][j] - (spread * cnt);
				}
			}

			// 2. 공기 순환
			for (int i = airCleaner[0] - 1; i > 0; i--)
				roomAfterSpread[i][0] = roomAfterSpread[i - 1][0];
			for (int i = 0; i < C - 1; i++)
				roomAfterSpread[0][i] = roomAfterSpread[0][i + 1];
			for (int i = 0; i < airCleaner[0]; i++)
				roomAfterSpread[i][C - 1] = roomAfterSpread[i + 1][C - 1];
			for (int i = C - 1; i > 1; i--)
				roomAfterSpread[airCleaner[0]][i] = roomAfterSpread[airCleaner[0]][i - 1];
			roomAfterSpread[airCleaner[0]][1] = 0;

			for (int i = airCleaner[1] + 1; i < R - 1; i++)
				roomAfterSpread[i][0] = roomAfterSpread[i + 1][0];
			for (int i = 0; i < C - 1; i++)
				roomAfterSpread[R - 1][i] = roomAfterSpread[R - 1][i + 1];
			for (int i = R - 1; i > airCleaner[1]; i--)
				roomAfterSpread[i][C - 1] = roomAfterSpread[i - 1][C - 1];
			for (int i = C - 1; i > 1; i--)
				roomAfterSpread[airCleaner[1]][i] = roomAfterSpread[airCleaner[1]][i - 1];
			roomAfterSpread[airCleaner[1]][1] = 0;

			// room 갱신
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					room[i][j] = roomAfterSpread[i][j];
				}
			}
		}
		int ans = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += room[i][j];
			}
		}
		System.out.println(ans);
	}
}
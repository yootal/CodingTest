import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] area = new int[N][N];
		int[][] vis = new int[N][N];
		int[][] nxtArea = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new ArrayDeque<>(); ;
		ArrayList<int[]> r = new ArrayList<>();;
		boolean flag;
		int day = 1;
		while (true) {
			flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i][j] == day)
						continue;
					r.clear();
					vis[i][j] = day;
					int cnt = 1;
					int total = area[i][j];
					q.offer(new int[] { i, j });
					r.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && vis[nx][ny] < day
									&& Math.abs(area[cur[0]][cur[1]] - area[nx][ny]) >= L
									&& Math.abs(area[cur[0]][cur[1]] - area[nx][ny]) <= R) {
								vis[nx][ny] = day;
								cnt++;
								total += area[nx][ny];
								q.offer(new int[] { nx, ny });
								r.add(new int[] { nx, ny });
							}
						}
					}
					if (r.size() > 1) {
						flag = false;
						for (int[] p : r) {
							nxtArea[p[0]][p[1]] = total / cnt;
						}
					} else
						nxtArea[i][j] = area[i][j];
				}
			}
			if (flag)
				break;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					area[i][j] = nxtArea[i][j];
				}
			}
			day++;
		}
		System.out.println(day - 1);
	}
}
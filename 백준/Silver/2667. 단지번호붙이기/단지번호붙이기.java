import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { 1, 0, -1, 0 };
	static final int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] map = new String[n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine();
		}
		ArrayList<Integer> ans = new ArrayList<>();
		boolean[][] v = new boolean[n][n];
		Queue<int[]> q;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i].charAt(j) == '1' && !v[i][j]) {
					int cnt = 1;
					v[i][j] = true;
					q = new ArrayDeque<>();
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								if (map[nx].charAt(ny) == '1' && !v[nx][ny]) {
									v[nx][ny] = true;
									cnt++;
									q.offer(new int[] { nx, ny });
								}
							}
						}
					}
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		for (int x : ans)
			sb.append(x).append("\n");
		System.out.print(sb);
	}

}
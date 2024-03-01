import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static char[][] state;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		state = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String row = br.readLine();
			for (int j = 0; j < 6; j++) {
				state[i][j] = row.charAt(j);
			}
		}
		int cnt = 0;
		while (true) {
			if (!bfs())
				break;
			cnt++;
		}
		System.out.println(cnt);
	}

	static boolean bfs() {
		v = new boolean[12][6];
		ArrayList<int[]> popList = new ArrayList<int[]>();
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (state[i][j] != '.' && !v[i][j]) {
					Queue<int[]> q = new ArrayDeque<>();
					v[i][j] = true;
					ArrayList<int[]> al = new ArrayList<int[]>();
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						al.add(new int[] { cur[0], cur[1] });
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !v[nx][ny]
									&& state[nx][ny] == state[cur[0]][cur[1]]) {
								v[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
						}
					}
					if (al.size() > 3) {
						popList.addAll(al);
					}
				}
			}
		}
		if (!popList.isEmpty()) {
			erase(popList);
			return true;
		} else
			return false;

	}

	static void erase(ArrayList<int[]> popList) {
		for (int[] p : popList) {
			state[p[0]][p[1]] = '.';
		}

		for (int j = 0; j < 6; j++) {
			for (int i = 11; i >= 0; i--) {
				if (state[i][j] != '.')
					continue;
				int k = i - 1;
				while (k >= 0 && state[k][j] == '.') {
					k--;
				}
				if (k == -1)
					break;
				swap(j, i, k);
			}
		}
	}

	static void swap(int col, int x1, int x2) {
		char temp = state[x1][col];
		state[x1][col] = state[x2][col];
		state[x2][col] = temp;
	}
}
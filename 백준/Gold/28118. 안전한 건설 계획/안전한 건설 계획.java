import java.io.*;
import java.util.*;

class Main {
	static int ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean check[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			check[i][i] = true;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			check[a][b] = true;
			check[b][a] = true;
		}
		while (true) {
			if (link(N, check)) {
				break;
			}
		}
		System.out.println(ans);
	}

	static boolean link(int N, boolean[][] check) {
		int flag = 0;
		int ti = -1, tj = -1, tk = -1;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (!check[i][j]) {
					for (int k = 0; k < N; k++) {
						if (check[i][k] && check[j][k]) {
							check[i][j] = true;
							check[j][i] = true;
							return false;
						}
						if (check[i][k]) {
							ti = i;
							tj = j;
							tk = k;
							flag = 1;
							continue;
						}
						if (check[j][k]) {
							ti = i;
							tj = j;
							tk = k;
							flag = 2;
						}
					}
				}
			}
		}
		if (flag == 1) {
			check[tj][tk] = true;
			check[tk][tj] = true;
			check[ti][tj] = true;
			check[tj][ti] = true;
			ans++;
			return false;
		} else if (flag == 2) {
			check[ti][tk] = true;
			check[tk][ti] = true;
			check[ti][tj] = true;
			check[tj][ti] = true;
			ans++;
			return false;
		} else {
			return true;
		}
	}
}
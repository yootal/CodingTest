import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static ArrayList<int[]> home;
	static ArrayList<int[]> chicken;
	static int[][] check;
	static int ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1)
					home.add(new int[] { i, j });
				else if (arr[i][j] == 2)
					chicken.add(new int[] { i, j });
			}
		}
		check = new int[M][2];
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(ans);
	}

	static void comb(int cnt, int idx) {
		if (cnt == M) {
			int total = 0;
			for (int[] h : home) {
				int dist = Integer.MAX_VALUE;
				for (int[] c : check) {
					dist = Math.min(dist, calc(h, c));
				}
				total += dist;
			}
			ans = Math.min(ans, total);
			return;
		}
		for (int i = idx; i < chicken.size(); i++) {
			check[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1);

		}
	}

	static int calc(int[] i, int[] j) {
		return Math.abs(i[0] - j[0]) + Math.abs(i[1] - j[1]);
	}
}
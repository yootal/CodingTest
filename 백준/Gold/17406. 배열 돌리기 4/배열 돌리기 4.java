import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] copyArr;
	static int[][] seq;
	static int[][] cmd;
	static boolean[] v;
	static int ans = Integer.MAX_VALUE;
	static int N;
	static int M;
	static int K;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copyArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cmd = new int[K][];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			cmd[k] = new int[] { r, c, s };
		}
		seq = new int[K][];
		v = new boolean[K];
		perm(0);
		System.out.println(ans);
	}

	static void oper(int r, int c, int s) {
		int r1 = r - s - 1, c1 = c - s - 1, r2 = r + s - 1, c2 = c + s - 1;
		while (r1 < r2) {
			int temp = copyArr[r1][c1];
			for (int i = r1; i < r2; i++) copyArr[i][c1] = copyArr[i + 1][c1];
			for (int i = c1; i < c2; i++) copyArr[r2][i] = copyArr[r2][i + 1];
			for (int i = r2; i > r1; i--) copyArr[i][c2] = copyArr[i - 1][c2];
			for (int i = c2; i > c1 + 1; i--) copyArr[r1][i] = copyArr[r1][i - 1];
			copyArr[r1][c1 + 1] = temp;
			r1++; c1++; r2--; c2--;
		}
	}

	static void perm(int cnt) {
		if (cnt == K) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyArr[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < K; i++) {
				oper(seq[i][0], seq[i][1], seq[i][2]);
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += copyArr[i][j];
				}
				min = Math.min(min, sum);
			}
			ans = Math.min(ans, min);
		}
		for (int i = 0; i < K; i++) {
			if (v[i])
				continue;
			v[i] = true;
			seq[cnt] = cmd[i];
			perm(cnt + 1);
			v[i] = false;
		}
	}
}
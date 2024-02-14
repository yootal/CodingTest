import java.io.*;
import java.util.*;

public class Main {
	static int[][] paper;
	static int[] cnt = new int[2];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(N, N, N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

	static void div(int x, int y, int len) {
		int sx = x - len;
		int sy = y - len;
		int flag = paper[sx][sy];
		if (len == 1) {
			cnt[flag]++;
			return;
		}
		int nxt_len = len / 2;
		for (int i = sx; i < sx + len; i++) {
			for (int j = sy; j < sy + len; j++) {
				if (paper[i][j] != flag) {
					div(x - nxt_len, y - nxt_len, nxt_len);
					div(x - nxt_len, y, nxt_len);
					div(x, y - nxt_len, nxt_len);
					div(x, y, nxt_len);
					return;
				}
			}
		}
		cnt[flag]++;
		return;
	}
}
import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K, ans;
	static int[][] film, temp;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			temp = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = film[i][j];
				}
			}
			ans = K;
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static boolean check() {
		boolean flag;
		for (int j = 0; j < W; j++) {
			int state = film[0][j];
			int cnt = 1;
			flag = false;
			for (int i = 1; i < D; i++) {
				if (state != film[i][j]) {
					state = film[i][j];
					cnt = 1;
				} else {
					cnt++;
				}
				if (cnt == K)
					flag = true;
			}
			if (!flag)
				return false;
		}
		return true;
	}

	static void dfs(int cnt, int idx) {
		if (cnt >= ans) // 현재 답보다 cnt가 높아지면 답이 아니다
			return;

		if (idx == D) { // 인덱스 끝까지 다돌고 최소값 확인
			if (check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}

		dfs(cnt, idx + 1); // 안 바꾼 상태

		for (int i = 0; i < W; i++)
			film[idx][i] = 1;
		dfs(cnt + 1, idx + 1); // idx 번째 줄을 1로 바꾼 상태

		for (int i = 0; i < W; i++)
			film[idx][i] = 0;
		dfs(cnt + 1, idx + 1); // idx 번째 줄을 0으로 바꾼 상태

		for (int i = 0; i < W; i++) // 바꿨던 배열 되돌리기
			film[idx][i] = temp[idx][i];

	}
}
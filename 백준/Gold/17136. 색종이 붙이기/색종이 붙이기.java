import java.io.*;
import java.util.*;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int extra[], paper[][], total;
	static boolean check[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		paper = new int[10][10]; // 종이
		extra = new int[] { 0, 5, 5, 5, 5, 5 }; // 사용할 수 있는 종이 수
		check = new boolean[10][10]; // 붙인 상태 기록
		total = 0; // 전체 1 수
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (paper[i][j] == 1)
					total++;
			}
		}
		solve(0, 0, 0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void solve(int row, int col, int paperCnt, int cnt) {

		if (paperCnt >= ans) // 1. 종이 수가 현재 최소 수보다 크거나 같으면 바로 리턴
			return;

		if (cnt == total) { // 모든 1 색종이로 덮었을 때 답 갱신
			ans = Math.min(ans, paperCnt);
			return;
		}

		for (int x = row; x < 10; x++) { // 전에 붙인 종이 다음부터 시작
			for (int y = col; y < 10; y++) {
				col = 0; // 다음 반복부터는 0부터
				if (paper[x][y] == 1 && !check[x][y]) {
					label: for (int k = 5; k > 0; k--) { // 1일 때 붙일 색종이 크기 반복문돌려서 찾는다.

						if (extra[k] == 0 || x + k > 10 || y + k > 10)
							continue; // 2. 여분 색종이가 없거나 색종이 크기가 종이를 넘어가면 바로 다음 크기로

						for (int i = x; i < x + k; i++) {
							for (int j = y; j < y + k; j++) {
								if (paper[i][j] != 1 || check[i][j])
									continue label; // 1이 아닌 칸이 존재하면 바로 다음으로 작은 색종이 확인
							}
						}

						for (int i = x; i < x + k; i++) { // 백트래킹시 돌아갈 상태 기록
							for (int j = y; j < y + k; j++) {
								check[i][j] = true;
							}
						}

						extra[k]--; // 사용한 색종이 수를 -1

						solve(x, y + k - 1, paperCnt + 1, cnt + k * k); // 다음 단계 재귀

						for (int i = x; i < x + k; i++) { // 돌아와서 원 상태로 복구
							for (int j = y; j < y + k; j++) {
								check[i][j] = false;
							}
						}
						extra[k]++; // 복구했으니 사용했던 색종이 수 다시 +1
					}
					return; // 3. 색종이 못붙이면 바로 리턴, 이거 안넣으면 종이 다돔
				}
			}
		}
	}
}
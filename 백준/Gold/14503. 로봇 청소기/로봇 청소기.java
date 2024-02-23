import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, M;

	static class Robot { // 로봇 상태 저장할 클래스
		int x, y, d;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Robot r = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(game(r, board));
	}

	static int game(Robot r, int[][] board) {

		int ans = 0; // 청소 횟수 저장

		while (true) {

			// 현재 칸이 청소되지 않은 경우, 현재 칸 청소
			if (board[r.x][r.y] == 0) {
				board[r.x][r.y] = 2;
				ans++;
			} else {
				boolean flag = true; // 빈 칸 유무 체크용

				// 주변 4칸 중 청소되지 않은 빈 칸 있는지 확인
				for (int d = 0; d < 4; d++) {
					int nx = r.x + dx[d];
					int ny = r.y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
						flag = false;
						break;
					}
				}

				// 빈 칸 없음
				if (flag) {
					int nx = r.x - dx[r.d];
					int ny = r.y - dy[r.d];
					// 후진 가능한지 확인하고 벽이면 게임을 끝낸다.
					if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
						if (board[nx][ny] != 1) {
							r.x = nx;
							r.y = ny;
						} else {
							return ans; // 청소 횟수 리턴
						}
					}
				}

				// 빈 칸 있음
				else {
					// 반시계 방향으로 90도 회전하고 빈 칸이면 전진
					r.d = (r.d + 3) % 4;
					int nx = r.x + dx[r.d];
					int ny = r.y + dy[r.d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
						r.x = nx;
						r.y = ny;
					}
				}
			}
		}
	}
}
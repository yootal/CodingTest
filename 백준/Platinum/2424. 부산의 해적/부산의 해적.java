import java.io.*;
import java.util.*;

class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char board[][] = new char[N][M];
		int visT[][] = new int[N][M]; // 방문 체크 + 최단 시간
		int minT[][] = new int[N][M]; // 바라보는 최단 시간
		Point Y = null; // 수아
		Point V = null; // 해적
		int tx = 0, ty = 0; // 보물
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
				switch (board[i][j]) {
				case 'Y':
					Y = new Point(i, j);
					break;
				case 'V':
					V = new Point(i, j);
					break;
				case 'T':
					tx = i;
					ty = j;
					break;
				}
			}
		}
		// 해적부터 최단시간 기록
		ArrayDeque<Point> q = new ArrayDeque<>();
		visT[V.x][V.y] = 1;
		q.offer(V);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 'I' && visT[nx][ny] == 0) {
					visT[nx][ny] = visT[cur.x][cur.y] + 1;
					q.offer(new Point(nx, ny));
				}
			}
		}
		// 가로줄 바라보는 최단 시간 기록
		for (int i = 0; i < N; i++) {
			int temp = Integer.MAX_VALUE; // 한 라인 최소값
			int idx = 0; // I 제외용 변수
			boolean flag = false;
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'I' && !flag) {
					for (int j2 = idx; j2 < j; j2++) {
						minT[i][j2] = temp;
					}
					flag = true;
					continue;
				} else if (board[i][j] != 'I' && flag) {
					idx = j;
					flag = false;
					temp = visT[i][j];
					continue;
				} else if (flag)
					continue;
				temp = Math.min(temp, visT[i][j]);
			}
			if (board[i][M - 1] != 'I') {
				for (int j2 = idx; j2 < M; j2++) {
					minT[i][j2] = temp;
				}
			}
		}
		// 세로줄까지 비교해서 해당 위치 바라보는 최단 시간 기록
		for (int j = 0; j < M; j++) {
			int temp = Integer.MAX_VALUE;
			int idx = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (board[i][j] == 'I' && !flag) {
					for (int i2 = idx; i2 < i; i2++) {
						minT[i2][j] = Math.min(minT[i2][j], temp);
					}
					flag = true;
					continue;
				} else if (board[i][j] != 'I' && flag) {
					idx = i;
					flag = false;
					temp = visT[i][j];
					continue;
				} else if (flag)
					continue;
				temp = Math.min(temp, visT[i][j]);
			}
			if (board[N - 1][j] != 'I') {
				for (int i2 = idx; i2 < N; i2++) {
					minT[i2][j] = Math.min(minT[i2][j], temp);
				}
			}
		}
		// 해적이 바라보는 최단 시간보다 빠를 때만 이동해서 보물찾기
		boolean ans = false;
		visT = new int[N][M];
		visT[Y.x][Y.y] = 1;
		q.offer(Y);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == tx && cur.y == ty) {
				ans = true;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 'I'
						&& minT[nx][ny] > visT[cur.x][cur.y] + 1 && visT[nx][ny] == 0) {
					visT[nx][ny] = visT[cur.x][cur.y] + 1;
					q.offer(new Point(nx, ny));
				}
			}
		}
		System.out.println(ans ? "YES" : "NO");
	}
}
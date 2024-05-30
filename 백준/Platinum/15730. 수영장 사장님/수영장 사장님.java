import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		final int dx[] = { -1, 0, 1, 0 };
		final int dy[] = { 0, 1, 0, -1 };
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 테두리 만들고 시작
		int N = Integer.parseInt(st.nextToken()) + 2;
		int M = Integer.parseInt(st.nextToken()) + 2;
		int block[][] = new int[N][M]; // 블록 높이
		int water[][] = new int[N][M]; // 물 높이
		boolean vis[][] = new boolean[N][M];
		for (int i = 1; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M - 1; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 물 높이 초기화
		for (int i = 0; i < N; i++) Arrays.fill(water[i], Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		water[0][0] = 0;
		pq.offer(new int[] { 0, 0, 0 }); // 테두리 높이 0 시작
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			if (vis[cur[0]][cur[1]]) break;
			vis[cur[0]][cur[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				// 1. 현 위치 물 높이와 주변 블록의 높이중 최대값 선택
				int h = Math.max(water[cur[0]][cur[1]], block[nx][ny]);
				// 2. 주변의 물 높이보다 h 작으면 갱신
				// 블록이 더 크면 어차피 계산시 0 나오고
				// 물 높이가 더 크면 해당 위치의 물 높이 기록 -> 이후 블록 높이 빼서 물 계산
				if (water[nx][ny] > h) {
					water[nx][ny] = h;
					pq.offer(new int[] { nx, ny, h });
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans += water[i][j] - block[i][j];
			}
		}
		System.out.println(ans);
	}
}
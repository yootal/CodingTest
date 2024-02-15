import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };
	static char board[][];
	static int cnt[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		cnt = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			String row = new String(br.readLine());
			board[i] = row.toCharArray();
		}
		System.out.println(bfs());
	}

	static int bfs() {
		cnt[0][0] = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0,cnt[0][0]});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N-1 && cur[1] == M-1) return cur[2];
			for(int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (board[nx][ny] == '1' && cnt[nx][ny] == 0) {
						cnt[nx][ny] = cur[2] + 1;
						q.add(new int[] {nx,ny,cnt[nx][ny]});
					}
				}
			}
		}
		return 0;
	}
}
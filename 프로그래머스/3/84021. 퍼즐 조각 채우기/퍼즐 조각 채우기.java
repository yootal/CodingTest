import java.util.*;

class Solution {
   	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };
	static int gb[][], t[][];
	static int gn, gm, tn, tm, ans;
	static boolean block_check[];
	static HashMap<Integer, int[][]>[] maps;

	public int solution(int[][] game_board, int[][] table) {
		// static 등록
		gb = game_board;
		t = table;
		gn = gb.length;
		gm = gb[0].length;
		tn = t.length;
		tm = t[0].length;

		// 각 회전의 블록 모양 저장할 map
		maps = new HashMap[4]; // map 배열 인덱스 = 회전 수
		for (int i = 0; i < 4; i++) {
			maps[i] = new HashMap<>(); // 키 값 = 블록 인덱스
		}
        
        // 1. 테이블 배열을 블록 인덱스 값으로 바꿔줌
        /*

        [1, 0, 0, 1, 1, 0]
        [1, 0, 1, 0, 1, 0]
        [0, 1, 1, 0, 1, 1]
        [0, 0, 1, 0, 0, 0]
        [1, 1, 0, 1, 1, 0]
        [0, 1, 0, 0, 0, 0]
        
        [1, 0, 0, 2, 2, 0]
        [1, 0, 3, 0, 2, 0]
        [0, 3, 3, 0, 2, 2]
        [0, 0, 3, 0, 0, 0]
        [4, 4, 0, 5, 5, 0]
        [0, 4, 0, 0, 0, 0]
        
        */
        
		int block_idx = 1; // 각 블록의 키값으로 사용할 인덱스
		int changeKey[][] = new int[tn][tm];
		for (int i = 0; i < tn; i++) {
			for (int j = 0; j < tm; j++) {
				if (t[i][j] == 1 && changeKey[i][j] == 0) {
					changeKey[i][j] = block_idx;
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < tn && ny >= 0 && ny < tm && t[nx][ny] == 1 && changeKey[nx][ny] == 0) {
								changeKey[nx][ny] = block_idx;
								q.offer(new int[] { nx, ny });
							}
						}
					}
					block_idx++;
				}
			}
		}

		// 2. 각 회전 당 블록 모양 등록
		/*
		 
		1 회전
		[0, 0, 2, 0, 0, 0]
		[2, 2, 2, 0, 5, 0]
		[2, 0, 0, 0, 5, 0]
		[0, 3, 3, 3, 0, 0]
		[0, 0, 3, 0, 4, 4]
		[1, 1, 0, 0, 4, 0]
		
		2 회전
		[0, 0, 0, 0, 4, 0]
		[0, 5, 5, 0, 4, 4]
		[0, 0, 0, 3, 0, 0]
		[2, 2, 0, 3, 3, 0]
		[0, 2, 0, 3, 0, 1]
		[0, 2, 2, 0, 0, 1]
		
		3 회전
		[0, 4, 0, 0, 1, 1]
		[4, 4, 0, 3, 0, 0]
		[0, 0, 3, 3, 3, 0]
		[0, 5, 0, 0, 0, 2]
		[0, 5, 0, 2, 2, 2]
		[0, 0, 0, 2, 0, 0]
		
		 */
		block_check = new boolean[block_idx]; // 사용한 블록 체크용 boolean 배열
		int[][] before = null;
		
		// 0 회전
		record(0, changeKey, tn, tm); // 각 테이블의 블록 모양 체크

		// 1 회전
		int[][] after_rotate = rotate(tm,tn,changeKey);
		record(1, after_rotate, tm, tn);
		before = after_rotate;

		// 2회전
		after_rotate = rotate(tn,tm,before);
		record(2, after_rotate, tn, tm);
		before = after_rotate;

		// 3 회전
		after_rotate = rotate(tm,tn,before);
		record(3, after_rotate, tm, tn);

		// 3. 게임 보드를 완탐하며 모든 블록을 끼워본다.
		boolean vis[][] = new boolean[gn][gm];
		for (int i = 0; i < gn; i++) {
			for (int j = 0; j < gm; j++) {
				if (gb[i][j] == 0 && !vis[i][j]) {
					vis[i][j] = true;
					int minX = i, maxX = i, minY = j, maxY = j;
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						minX = Math.min(minX, cur[0]);
						maxX = Math.max(maxX, cur[0]);
						minY = Math.min(minY, cur[1]);
						maxY = Math.max(maxY, cur[1]);
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < gn && ny >= 0 && ny < gm && !vis[nx][ny] && gb[nx][ny] == 0) {
								vis[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
						}
					}
					// 게임 보드의 빈칸
					int tempGb[][] = new int[maxX - minX + 1][maxY - minY + 1];
					for (int r = minX; r <= maxX; r++) {
						for (int c = minY; c <= maxY; c++) {
							tempGb[r - minX][c - minY] = gb[r][c];
						}
					}

					// 모든 블록을 끼워본다
					boolean flag = true;
					for (int mi = 0; mi < 4; mi++) {
						for (int mk = 1; mk < block_idx; mk++) {
							if (block_check[mk])
								continue;
							if (check_case(mi, mk, tempGb)) {
								flag = false;
								break;
							}
						}
						if (!flag)
							break;
					}
				}
			}
		}
		return ans;
	}

	// 블록 회전 함수
	private int[][] rotate(int n, int m, int[][] before) {
		int after[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				after[m - j - 1][i] = before[i][j];
			}
		}
		return after;
	}

	static boolean check_case(int mi, int mk, int[][] board_blank) {
		int[][] cur_block = maps[mi].get(mk);
		// 가로, 세로 길이가 다르면 불가능
		if (cur_block.length != board_blank.length || cur_block[0].length != board_blank[0].length)
			return false;
		int cnt = 0;
		for (int tx = 0; tx < cur_block.length; tx++) {
			for (int ty = 0; ty < cur_block[0].length; ty++) {
				if (cur_block[tx][ty] != board_blank[tx][ty])
					return false;
				if (cur_block[tx][ty] == 0)
					cnt++;
			}
		}
		ans += cnt;
		block_check[mk] = true; // 사용한 블록의 키 방문처리
		return true;
	}

	// 블록 모양을 map에 등록하는 함수
	static void record(int map_idx, int[][] temp_table, int tn, int tm) {
		boolean vis[][] = new boolean[tn][tm];
		for (int i = 0; i < tn; i++) {
			for (int j = 0; j < tm; j++) {
				if (temp_table[i][j] != 0 && !vis[i][j]) {
					int minX = i, maxX = i, minY = j, maxY = j;
					int flag = temp_table[i][j];
					vis[i][j] = true;
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						minX = Math.min(minX, cur[0]);
						maxX = Math.max(maxX, cur[0]);
						minY = Math.min(minY, cur[1]);
						maxY = Math.max(maxY, cur[1]);
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < tn && ny >= 0 && ny < tm && !vis[nx][ny] && temp_table[nx][ny] == flag) {
								vis[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
						}
					}
					int temp[][] = new int[maxX - minX + 1][maxY - minY + 1];
					for (int r = minX; r <= maxX; r++) {
						for (int c = minY; c <= maxY; c++) {
							temp[r - minX][c - minY] = temp_table[r][c] == 0 ? 1 : 0;
						}
					}
					maps[map_idx].put(flag, temp);
				}
			}
		}
	}
}
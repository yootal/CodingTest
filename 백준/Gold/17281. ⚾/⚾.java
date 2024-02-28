import java.io.*;
import java.util.*;

public class Main {
	static int[][] play;
	static int[] seq;
	static boolean[] v;
	static int N, playerIdx, ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		play = new int[N][9];
		seq = new int[9];
		v = new boolean[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				play[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		perm(0);
		System.out.println(ans);
	}

	static void perm(int cnt) {
		if (cnt == 9) {
			ans = Math.max(ans, game());
			return;
		}
		if (cnt == 3) {
			seq[cnt] = 0;
			perm(cnt + 1);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (v[i])
				continue;
			v[i] = true;
			seq[cnt] = i;
			perm(cnt + 1);
			v[i] = false;
		}
	}

	static int game() {
		playerIdx = 0;
		int score = 0;
		int turn = 0;
		while (turn != N) {
			int flag = 0;
			int outCnt = 0;
			while (true) {
				int action = play[turn][seq[playerIdx]];
				playerIdx = (playerIdx + 1) % 9;
				if (action == 0) {
					outCnt++;
					if (outCnt == 3) {
						outCnt = 0;
						break;
					}
				} else {
					for (int i = 0; i < action; i++) {
						if (i == 0) {
							flag <<= 1;
							flag += 1;
						} else
							flag <<= 1;
						if ((flag & (1 << 3)) != 0) {
							flag -= (1 << 3);
							score++;
						}
					}
				}
			}
			turn++;
		}
		return score;
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N;
	static int state[][];
	static int nutrient[][];
	static PriorityQueue<Integer>[][] tree;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		state = new int[N][N];
		nutrient = new int[N][N];
		tree = new PriorityQueue[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				state[i][j] = 5;
				tree[i][j] = new PriorityQueue<>();
				nutrient[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			tree[x - 1][y - 1].offer(z);
		}
		for (int i = 0; i < K; i++) {
			spring_summer();
			fall();
			winter();
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += tree[i][j].size();
			}
		}
		System.out.print(cnt);
	}

	static void spring_summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				PriorityQueue<Integer> temp = new PriorityQueue<>();
				while (!tree[i][j].isEmpty() && tree[i][j].peek() <= state[i][j]) {
					int cur = tree[i][j].poll();
					state[i][j] -= cur;
					temp.offer(cur + 1);
				}
				for (int v : tree[i][j]) {
					state[i][j] += v / 2;
				}
				tree[i][j] = temp;
			}
		}
	}

	static void fall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int age : tree[i][j]) {
					if (age % 5 != 0)
						continue;
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							tree[nx][ny].offer(1);
						}
					}
				}
			}
		}
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				state[i][j] += nutrient[i][j];
			}
		}
	}
}
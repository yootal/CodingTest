import java.io.*;
import java.util.*;

class Main {
	static int N, num[];
	static ArrayDeque<int[]> stack;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		stack = new ArrayDeque<int[]>();
		solve(0);
	}

	static void solve(int turn) {
		if (turn == 2) {
			for (int i = 0; i < N; i++) {
				if (num[i] != i + 1) {
					return;
				}
			}
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				int cur[] = stack.pollLast();
				sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int s1 = 0, e1 = N - 1;
		for (int i = 0; i < N; i++) {
			if (num[i] == i + 1) {
				continue;
			}
			s1 = i;
			int target = i + 1;
			for (int j = i + 1; j < N; j++) {
				if (num[j] == target) {
					e1 = j;
					int temp[] = new int[e1 - s1 + 1];
					for (int d = 0; d <= e1 - s1; d++) {
						temp[d] = num[s1 + d];
					}
					for (int d = 0; d <= e1 - s1; d++) {
						num[s1 + d] = temp[e1 - s1 - d];
					}
					stack.push(new int[] { s1 + 1, e1 + 1 });
					solve(turn + 1);
					stack.pop();
					for (int d = 0; d <= e1 - s1; d++) {
						num[s1 + d] = temp[d];
					}
					break;
				}
			}
			break;
		}
		int s2 = 0, e2 = N - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (num[i] == i + 1) {
				continue;
			}
			e2 = i;
			int target = i + 1;
			for (int j = i - 1; j >= 0; j--) {
				if (num[j] == target) {
					s2 = j;
					int temp[] = new int[e2 - s2 + 1];
					for (int d = 0; d <= e2 - s2; d++) {
						temp[d] = num[s2 + d];
					}
					for (int d = 0; d <= e2 - s2; d++) {
						num[s2 + d] = temp[e2 - s2 - d];
					}
					stack.push(new int[] { s2 + 1, e2 + 1 });
					solve(turn + 1);
					stack.pop();
					for (int d = 0; d <= e2 - s2; d++) {
						num[s2 + d] = temp[d];
					}
					break;
				}
			}
			break;
		}
		if (s1 == 0 && e2 == N - 1) {
			stack.push(new int[] { 1, 1 });
			solve(turn + 1);
		}
	}
}
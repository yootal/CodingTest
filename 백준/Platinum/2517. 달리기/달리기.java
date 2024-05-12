import java.io.*;
import java.util.*;

class Main {
	static int segTree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		int sortedNum[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sortedNum[i] = num[i];
		}
		Arrays.sort(sortedNum);
		HashMap<Integer, Integer> numIdx = new HashMap<>();
		for (int i = 0; i < N; i++) {
			numIdx.put(sortedNum[i], i);
		}
		int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int treeSize = 1 << h;
		int startIdx = treeSize / 2;
		segTree = new int[treeSize];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int curIdx = numIdx.get(num[i]);
			change(startIdx + curIdx);
			sb.append(calcSum(startIdx + curIdx, startIdx + N - 1)).append("\n");
		}
		System.out.println(sb);
	}

	static void change(int idx) {
		while (idx > 0) {
			segTree[idx] += 1;
			idx /= 2;
		}
	}

	static long calcSum(int s, int e) {
		long total = 0;
		while (s <= e) {
			if (s % 2 == 1) {
				total += segTree[s];
				s++;
			}
			if (e % 2 == 0) {
				total += segTree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return total;
	}
}
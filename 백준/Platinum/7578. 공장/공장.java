import java.io.*;
import java.util.*;

class Main {
	static int segTree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int numA[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numA[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> numB = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numB.put(Integer.parseInt(st.nextToken()), i);
		}

		int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int treeSize = 1 << h;
		int startIdx = treeSize / 2 - 1;
		segTree = new int[treeSize + 1];
		long ans = 0;
		for (int idxA = 0; idxA < N; idxA++) {
			int idxB = numB.get(numA[idxA]);
			change(startIdx + idxB);
			ans += calcSum(startIdx + idxB + 1, startIdx + N - 1);
		}
		System.out.println(ans);
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
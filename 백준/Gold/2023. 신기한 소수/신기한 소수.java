import java.io.*;

public class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		back_tracking(2, 1);
		back_tracking(3, 1);
		back_tracking(5, 1);
		back_tracking(7, 1);
		System.out.println(sb);
	}

	static void back_tracking(int num, int cnt) {
		if (cnt == N) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 0)
				continue;
			int num_nxt = num * 10 + i;
			if (isPrime(num_nxt)) {
				back_tracking(num_nxt, cnt + 1);
			}
		}
	}

	static boolean isPrime(int x) {
		for (int i = 2; i <= x / 2; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
}
import java.io.*;

class Main {
	static int N, num[], ans;
	static char oper[];
	static boolean check[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String row = br.readLine();
		num = new int[N / 2 + 1];
		oper = new char[N / 2];
		check = new boolean[N / 2];
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				num[i / 2] = row.charAt(i) - '0';
			else
				oper[i / 2] = row.charAt(i);
		}
		ans = -Integer.MAX_VALUE;
		calc(1);
		System.out.println(ans);
	}

	static void calc(int cur) {
		if (cur == N) {
			int tempNum[] = new int[N / 2 + 1];
			for (int i = 0; i < N / 2 + 1; i++) {
				tempNum[i] = num[i];
			}
			for (int i = 0; i < N / 2; i++) {
				if (check[i]) {
					switch (oper[i]) {
					case '+':
						tempNum[i] = num[i] + num[i + 1];
						break;
					case '-':
						tempNum[i] = num[i] - num[i + 1];
						break;
					default:
						tempNum[i] = num[i] * num[i + 1];
					}
				}
			}
			int total = tempNum[0];
			for (int i = 0; i < N / 2; i++) {
				if (!check[i]) {
					switch (oper[i]) {
					case '+':
						total += tempNum[i + 1];
						break;
					case '-':
						total -= tempNum[i + 1];
						break;
					default:
						total *= tempNum[i + 1];
					}
				}
			}
			ans = Math.max(ans, total);
			return;
		}
		if (cur > 1 && !check[cur / 2 - 1] || cur == 1) {
			check[cur / 2] = true;
			calc(cur + 2);
			check[cur / 2] = false;
		}
		calc(cur + 2);
	}
}
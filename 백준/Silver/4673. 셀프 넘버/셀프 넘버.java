public class Main {
	static boolean[] check = new boolean[10001];

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			d(i);
			if (!check[i])
				sb.append(i).append("\n");
		}
		System.out.print(sb);
	}

	static void d(int x) {
		int sum = x;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		if (sum > 10000)
			return;
		check[sum] = true;
	}

}
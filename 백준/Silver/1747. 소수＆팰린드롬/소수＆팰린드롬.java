import java.io.*;

public class Main {
	static int n;
	static final int limit = 2000000;
	static boolean[] num;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new boolean[limit + 1];
		num[0] = num[1] = true;
		for (int i = 2; i * i <= limit; i++) {
			if (!num[i]) {
				for (long j = (long) i * i; j <= limit; j += i) {
					num[(int) j] = true;
				}
			}
		}
		System.out.println(find());
	}

	static int find() {
		for (int i = n; i <= limit; i++) {
			if (!num[i]) {
				String x = Integer.toString(i);
				if (x.length() == 1)
					return i;
				boolean flag = false;
				for (int j = 0; j < x.length() / 2; j++) {
					if (x.charAt(j) != x.charAt(x.length() - j - 1)) {
						flag = true;
						break;
					}
				}
				if (flag)
					continue;
				return i;
			}
		}
		return 0;
	}
}
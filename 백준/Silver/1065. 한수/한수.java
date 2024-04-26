import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= x; i++) {
			if (check(i))
				cnt++;
		}
		System.out.println(cnt);
	}

	static boolean check(int x) {
		int num = x;
		int pre = x % 10;
		num /= 10;
		int diff = 10;
		while (num != 0) {
			int cur = num % 10;
			num /= 10;
			if (diff == 10) {
				diff = pre - cur;
			} else {
				if (diff != pre - cur)
					return false;
			}
			pre = cur;
		}
		return true;
	}
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b)
				System.out.println(lcm(a, b));
			else
				System.out.println(lcm(b, a));
		}
	}

	static int gcd(int x, int y) {
		if (x % y == 0)
			return y;
		return gcd(y, x % y);
	}

	static int lcm(int x, int y) {
		return x / gcd(x, y) * y;
	}
}
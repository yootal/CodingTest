import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		if (a > b)
			for (int i = 0; i < (int) gcd(a, b); i++) {
				sb.append("1");
			}
		else
			for (int i = 0; i < (int) gcd(b, a); i++) {
				sb.append("1");
			}
		System.out.println(sb);
	}

	static long gcd(long x, long y) {
		if (x % y == 0)
			return y;
		return gcd(y, x % y);
	}

}
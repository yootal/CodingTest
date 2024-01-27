import java.io.*;
import java.util.*;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = gcd(a, b);
			if (d % g == 0)
				sb.append("Yes").append("\n");
			else
				sb.append("No").append("\n");
		}
		System.out.println(sb);
	}

	static int gcd(int x, int y) {
		if (x % y == 0)
			return y;
		return gcd(y, x % y);
	}

}
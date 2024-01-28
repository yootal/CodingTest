import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			if (i == n) {
				for (int k = 1; k <= 2 * n - 1; k++)
					sb.append("*");
			} else {
				for (int j = 1; j <= n - i; j++) {
					sb.append(" ");
				}
				for (int j2 = 1; j2 < 2 * i; j2++) {
					if (j2 == 1 || j2 == 2 * i - 1) {
						sb.append("*");
					} else
						sb.append(" ");
				}

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
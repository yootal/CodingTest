import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				sb.append(" ");
			}
			for (int k = 0; k < 2 * i; k++) {
				if (k % 2 == 0) {
					sb.append("*");
				} else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
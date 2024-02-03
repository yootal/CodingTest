import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {
					sb.append("* ");
				}
			} else {
				for (int j = 0; j < n; j++) {
					sb.append(" *");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		int[] swi = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			swi[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (s == 1) {
				int x = num;
				while (x - 1 >= 0 && x - 1 < n) {
					swi[x - 1] ^= 1;
					x += num;
				}
			} else {
				int l = num - 1;
				int r = num + 1;
				swi[num - 1] ^= 1;
				while (l - 1 >= 0 && r - 1 < n) {
					if (swi[l - 1] == swi[r - 1]) {
						swi[l - 1] ^= 1;
						l--;
						swi[r - 1] ^= 1;
						r++;
					} else
						break;
				}

			}
		}
		for (int i = 0; i < n; i++) {
			sb.append(swi[i] + " ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}
		System.out.print(sb);

	}
}
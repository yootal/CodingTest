import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer stt = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(stt.nextToken());
		}
		Arrays.sort(num);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int l = 0;
			int r = N - 1;
			while (l < r) {
				if (num[l] + num[r] < num[i]) {
					l++;
				} else if (num[l] + num[r] > num[i]) {
					r--;
				} else {
					if (l != i && r != i) {
						ans++;
						break;
					}
					else if(l == i) {
						l++;
					}
					else if(r == i) {
						r--;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j < a + 10; j++) {
				for (int j2 = b; j2 < b + 10; j2++) {
					paper[j][j2] = 1;
				}
			}
		}
		int ans = 0;
		for (int j = 0; j < 100; j++) {
			for (int j2 = 0; j2 < 100; j2++) {
				ans += paper[j][j2];
			}
		}
		System.out.println(ans);
	}
}
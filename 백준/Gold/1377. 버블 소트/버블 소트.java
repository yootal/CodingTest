import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int[][] arr = new int[N][];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = new int[] { num, i };
		}
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, arr[i][1] - i);
		}
		System.out.println(ans + 1);
	}

}
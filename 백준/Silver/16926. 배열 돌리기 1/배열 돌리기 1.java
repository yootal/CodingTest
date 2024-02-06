import java.io.*;
import java.util.*;

public class Main {
	static int r;
	static int c;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (k-- > 0) {
			arr = rotate(arr);
		}
		StringBuilder sb = new StringBuilder();
		for (int[] row : arr) {
			for (int x : row) {
				sb.append(x + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static int[][] rotate(int[][] arr) {
		int[][] newArr = new int[r][c];
		int r1 = 0, c1 = 0;
		int r2 = r - 1, c2 = c - 1;
		while (r1 < r2 && c1 < c2) {
			for (int i = c1; i < c2; i++) {
				newArr[r1][i] = arr[r1][i + 1];
			}
			for (int i = r1; i < r2; i++) {
				newArr[i][c2] = arr[i + 1][c2];
			}
			for (int i = c2; i > c1; i--) {
				newArr[r2][i] = arr[r2][i - 1];
			}
			for (int i = r2; i > r1; i--) {
				newArr[i][c1] = arr[i - 1][c1];
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
		return newArr;
	}

}
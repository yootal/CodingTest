import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] num = new int[9];
		for (int i = 0; i < 9; i++) {
			int n = Integer.parseInt(br.readLine());
			num[i] = n;
			sum += n;
		}
		label: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;
				if (sum - num[i] - num[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							System.out.println(num[k]);
						}
					}
					break label;
				}
			}
		}

	}

}
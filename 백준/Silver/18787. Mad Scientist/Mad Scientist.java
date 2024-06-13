import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String A = br.readLine();
		String B = br.readLine();
		int cnt = 0;
		boolean check = false;
		for (int i = 0; i < N; i++) {
			if (!check && A.charAt(i) != B.charAt(i)) {
				check = true;
				cnt++;
			} else if (check && A.charAt(i) == B.charAt(i)) {
				check = false;
			}
		}
		if (check)
			cnt++;
		System.out.println(cnt);
	}
}
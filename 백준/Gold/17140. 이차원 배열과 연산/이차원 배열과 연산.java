import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], row_length, col_length, cnt[];
	static ArrayList<Cnt> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 최대 배열 크기 100, 100 넘어가면 버린다.
		arr = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 처음 시작 3x3 배열
		row_length = 3;
		col_length = 3;
		int time = 0;
		while (time <= 100) { // 100초까지 가능
			if (arr[r - 1][c - 1] == k)
				break;
			if (row_length >= col_length) // 행 >= 열이면 R연산
				operR();
			else
				operC();
			time++;
		}
		System.out.println(time == 101 ? -1 : time); // 101초면 -1 출력
	}

	static void operR() { // R연산
		int update_col_length = 0; // 가장 큰 크기로 갱신을 위한 변수
		for (int i = 0; i < row_length; i++) {
			cnt = new int[101]; // 등장 횟수를 저장할 배열
			for (int j = 0; j < col_length; j++) {
				if (arr[i][j] == 0) // 0은 무시한다
					continue;
				cnt[arr[i][j]]++;
				arr[i][j] = 0; // 배열을 0으로 초기화 해줘야한다
			}
			al.clear(); // 카운팅한 수만 모아서 정렬
			for (int j = 1; j < 101; j++) {
				if (cnt[j] > 0)
					al.add(new Cnt(j, cnt[j]));
			}
			Collections.sort(al);
			// 갯수로 먼저 비교하고 같으면 숫자 비교
			int size = al.size() * 2; // 수, 수의 갯수를 기록하기 때문에 사이즈는 2배
			if (size > 100)
				size = 100; // 100까지만 쓴다
			for (int j = 0; j < size; j += 2) {
				arr[i][j] = al.get(j / 2).idx;
				arr[i][j + 1] = al.get(j / 2).cnt;
			}
			update_col_length = Math.max(size, update_col_length); // 가장 큰 크기를 기록
		}
		col_length = update_col_length; // 가장 큰 크기로 col_length 갱신
	}

	static void operC() {
		int update_row_length = 0;
		for (int j = 0; j < col_length; j++) {
			cnt = new int[101];
			for (int i = 0; i < row_length; i++) {
				if (arr[i][j] == 0)
					continue;
				cnt[arr[i][j]]++;
				arr[i][j] = 0;
			}
			al.clear();
			for (int i = 1; i < 101; i++) {
				if (cnt[i] > 0)
					al.add(new Cnt(i, cnt[i]));
			}
			Collections.sort(al);
			int size = al.size() * 2;
			if (size > 100)
				size = 100;
			for (int i = 0; i < size; i += 2) {
				arr[i][j] = al.get(i / 2).idx;
				arr[i + 1][j] = al.get(i / 2).cnt;
			}
			update_row_length = Math.max(size, update_row_length);
		}
		row_length = update_row_length;
	}

	static class Cnt implements Comparable<Cnt> {
		int idx, cnt;

		public Cnt(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Cnt o) {
			return cnt == o.cnt ? idx - o.idx : cnt - o.cnt;
		}

	}
}
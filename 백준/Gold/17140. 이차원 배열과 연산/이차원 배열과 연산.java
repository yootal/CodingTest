import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int row_length;
	static int col_length;
	static HashMap<Integer, Integer> countMap;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		row_length = 3;
		col_length = 3;
		int time = 0;
		while (time <= 100) {
			if (arr[r - 1][c - 1] == k)
				break;
			if (row_length >= col_length)
				operR();
			else
				operC();
			// 출력용
			// for (int[] row : arr) System.out.println(Arrays.toString(row));
			// System.out.println();
			time++;
		}
		System.out.println(time == 101 ? -1 : time);

	}

	static void operR() {
		int update_col_length = 0;
		for (int i = 0; i < row_length; i++) {
			countMap = new HashMap<>();
			for (int j = 0; j < col_length; j++) {
				if (arr[i][j] == 0)
					continue;
				if (countMap.containsKey(arr[i][j])) {
					countMap.put(arr[i][j], countMap.get(arr[i][j]) + 1);
				} else {
					countMap.put(arr[i][j], 1);
				}
				arr[i][j] = 0;

			}
			List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
			entryList.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).thenComparing(Map.Entry::getKey));
			int size = entryList.size() * 2;
			if (size > 100)
				size = 100;
			for (int j = 0; j < size; j += 2) {
				arr[i][j] = entryList.get(j / 2).getKey();
				arr[i][j + 1] = entryList.get(j / 2).getValue();
			}
			update_col_length = Math.max(size, update_col_length);
		}
		col_length = update_col_length;
	}

	static void operC() {
		int update_row_length = 0;
		for (int j = 0; j < col_length; j++) {
			countMap = new HashMap<>();
			for (int i = 0; i < row_length; i++) {
				if (arr[i][j] == 0)
					continue;
				if (countMap.containsKey(arr[i][j])) {
					countMap.put(arr[i][j], countMap.get(arr[i][j]) + 1);
				} else {
					countMap.put(arr[i][j], 1);
				}
				arr[i][j] = 0;

			}
			List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
			entryList.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).thenComparing(Map.Entry::getKey));
			int size = entryList.size() * 2;
			if (size > 100)
				size = 100;
			for (int i = 0; i < size; i += 2) {
				arr[i][j] = entryList.get(i / 2).getKey();
				arr[i + 1][j] = entryList.get(i / 2).getValue();
			}
			update_row_length = Math.max(size, update_row_length);
		}
		row_length = update_row_length;
	}

}
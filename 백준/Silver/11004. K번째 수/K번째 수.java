import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		quick_sort(num, 0, N - 1, K - 1);
		System.out.println(num[K - 1]);
	}

	static void quick_sort(int[] arr, int s, int e, int k) {
		if (s < e) {
			int pivot = partition(arr, s, e);
			if (pivot == k) {
				return;
			} else if (k < pivot) {
				quick_sort(arr, s, pivot - 1, k);
			} else {
				quick_sort(arr, pivot + 1, e, k);
			}
		}
	}

	static int partition(int[] arr, int s, int e) {
		if (s + 1 == e) {
			if (arr[s] > arr[e])
				swap(arr, s, e);
			return e;
		}
		int m = (s + e) / 2;
		swap(arr, s, m);
		int pivot = arr[s];
		int i = s + 1, j = e;
		while (i <= j) {
			while (j >= s + 1 && pivot < arr[j]) {
				j--;
			}
			while (i <= e && pivot > arr[i]) {
				i++;
			}
			if (i <= j) {
				swap(arr, i++, j--);
			}
		}
		arr[s] = arr[j];
		arr[j] = pivot;
		return j;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
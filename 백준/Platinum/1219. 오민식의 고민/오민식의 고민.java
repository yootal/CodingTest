import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stt.nextToken());
		int S = Integer.parseInt(stt.nextToken());
		int E = Integer.parseInt(stt.nextToken());
		int M = Integer.parseInt(stt.nextToken());
		Edge[] edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			stt = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stt.nextToken());
			int b = Integer.parseInt(stt.nextToken());
			int c = Integer.parseInt(stt.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		int[] city = new int[N];
		stt = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(stt.nextToken());
		}
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[S] = 0;
		for (int i = 0; i < N * 2; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = edges[j];
				if (dist[edge.start] == Long.MAX_VALUE)
					continue;
				// 출발이 사이클이면 도착도 사이클
				else if (dist[edge.start] == Long.MIN_VALUE)
					dist[edge.end] = Long.MIN_VALUE;
				else if (dist[edge.end] > dist[edge.start] + edge.price - city[edge.end]) {
					dist[edge.end] = dist[edge.start] + edge.price - city[edge.end];
					// N-1 이후 업데이트 되면 사이클로 판별
					if (i >= N - 1)
						dist[edge.end] = Long.MIN_VALUE;
				}
			}

		}

		if (dist[E] == Long.MAX_VALUE) {
			System.out.println("gg");
		} else if (dist[E] == Long.MIN_VALUE)
			System.out.println("Gee");
		else {
			System.out.println(city[S] - dist[E]);
		}
	}

	static class Edge {
		int start, end, price;

		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}
	}
}
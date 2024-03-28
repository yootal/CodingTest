import java.io.*;
import java.util.*;

public class Solution {
	static class Guest implements Comparable<Guest> {
		int idx, time;
		boolean check;

		public Guest(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Guest o) {
			return time == o.time ? Integer.compare(idx, o.idx) : Integer.compare(time, o.time);
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Guest> timePQ = new PriorityQueue<>(); // 처음 도착 우선순위 큐
		ArrayDeque<Guest> wait1 = new ArrayDeque<>(); // 도착 -> 접수 대기
		ArrayDeque<Guest> wait2 = new ArrayDeque<>(); // 접수 -> 정비 대기
		Guest[] reception; // 접수
		Guest[] repair; // 정비
		for (int tc = 1; tc <= T; tc++) {
			int receptionCnt = 0;
			int repairCnt = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			reception = new Guest[N];
			int M = Integer.parseInt(st.nextToken());
			repair = new Guest[M];
			int K = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] a = new int[N];
			int[] b = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				timePQ.offer(new Guest(i, Integer.parseInt(st.nextToken())));
			}

			int endCnt = 0; // 끝난 사람 수 카운팅
			int time = 0; // 현재 시간
			int ans = 0; // 답

			while (endCnt != K) {

				// 1. 정비 끝난 사람 빼주기
				for (int i = 0; i < M; i++) {
					if (repair[i] != null) {
						repair[i].time++;
						if (repair[i].time == b[i]) {
							if (i + 1 == B && repair[i].check) {
								ans += repair[i].idx;
							}

							// 정비에서 빼줌
							repair[i] = null;
							endCnt++;
							repairCnt--;
						}
					}
				}

				// 2. 대기2에 있는애 넣어주기
				while (!wait2.isEmpty() && repairCnt < M) {
					Guest cur = wait2.poll();
					for (int i = 0; i < M; i++) {
						if (repair[i] == null) {
							cur.time = 0;
							repair[i] = cur;
							repairCnt++;
							break;
						}
					}
				}

				// 3. 접수 끝난사람 정비 or 대기2
				for (int i = 0; i < N; i++) {
					if (reception[i] != null) {
						reception[i].time++;
						if (reception[i].time == a[i]) {
							Guest temp = new Guest(reception[i].idx, 0);
							if (i + 1 == A) {
								temp.check = true;
							}

							// 접수에서 빼주고
							reception[i] = null;
							receptionCnt--;

							// 정비에 자리 있으면 넣고 없으면 대기2로
							if (repairCnt < M) {
								for (int j = 0; j < M; j++) {
									if (repair[j] == null) {
										repair[j] = temp;
										repairCnt++;
										break;
									}
								}
							} else {
								wait2.add(temp);
							}
						}
					}
				}

				// 4. 대기1에 있는애 넣어주기
				while (!wait1.isEmpty() && receptionCnt < N) {
					Guest cur = wait1.poll();
					for (int i = 0; i < N; i++) {
						if (reception[i] == null) {
							cur.time = 0;
							reception[i] = cur;
							receptionCnt++;
							break;
						}
					}
				}

				// 5. 도착한 사람 접수 or 대기1
				while (!timePQ.isEmpty() && timePQ.peek().time == time) {
					Guest cur = timePQ.poll();
					if (receptionCnt < N) {
						for (int i = 0; i < N; i++) {
							if (reception[i] == null) {
								cur.time = 0;
								reception[i] = cur;
								receptionCnt++;
								break;
							}
						}
					} else {
						wait1.add(cur);
					}
				}
				time++;
			}
			sb.append("#").append(tc + " ").append(ans == 0 ? -1 : ans).append("\n");
		}
		System.out.print(sb);
	}
}
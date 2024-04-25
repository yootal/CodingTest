import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		PriorityQueue<int[]> inPq = new PriorityQueue<>(
				(o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
		PriorityQueue<int[]> runPq = new PriorityQueue<>(
                (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
		int minIn = Integer.MAX_VALUE;
        for (int i = 0; i < jobs.length; i++) {
            minIn = Math.min(minIn, jobs[i][0]);
			inPq.offer(new int[] { jobs[i][0], jobs[i][1] });
		}
		int answer = 0;
		int cnt = 0;
		int wait = minIn;
		while (cnt < jobs.length) {
			while (!inPq.isEmpty() && inPq.peek()[0] <= wait) {
				runPq.offer(inPq.poll());
			}
			if (!runPq.isEmpty()) {
				int cur[] = runPq.poll();
				answer += cur[1] + wait - cur[0];
				wait += cur[1];
				cnt++;
			} else {
				int cur[] = inPq.poll();
                wait = cur[0];
				answer += cur[1] + wait - cur[0];
				wait += cur[1];
				cnt++;
			}
		}
		return answer / jobs.length;
	}
}
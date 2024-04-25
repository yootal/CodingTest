import java.util.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> sumMap = new HashMap<>();
		HashMap<String, PriorityQueue<int[]>> pqMap = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (sumMap.containsKey(genres[i])) {
				int cnt = sumMap.get(genres[i]);
				sumMap.put(genres[i], cnt + plays[i]);
				pqMap.get(genres[i]).offer(new int[] { plays[i], i });
			} else {
				sumMap.put(genres[i], plays[i]);
				pqMap.put(genres[i], new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]));
				pqMap.get(genres[i]).offer(new int[] { plays[i], i });
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
		for (Map.Entry<String, Integer> e : sumMap.entrySet()) {
			pq.offer(e);
		}
		while (!pq.isEmpty()) {
			Map.Entry<String, Integer> e = pq.poll();
			int cnt = 0;
			while (pqMap.get(e.getKey()).size() > 0 && cnt < 2) {
				int cur[] = pqMap.get(e.getKey()).poll();
				al.add(cur[1]);
				cnt++;
			}
		}
		int answer[] = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}
}
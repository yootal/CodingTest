import java.io.*;
import java.util.*;

public class Solution {
	static int MAX = 5000;
	static StringBuilder sb = new StringBuilder();

	static class Node { // 각 노드 정보
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class LinkedList {
		Node head;
		Node tail;
		Node[] nodeArr;
		int nodeCnt;

		public LinkedList() { // 연결 리스트 생성자
			head = null;
			nodeArr = new Node[MAX];
			nodeCnt = 0;
		}

		Node getNewNode(int data) { // 새로운 노드 생성하고 리턴
			nodeArr[nodeCnt] = new Node(data);
			return nodeArr[nodeCnt++];
		}

		void insert(int idx, int[] nums) { // idx 이후에 숫자들 추가
			int st = 0;
			if (idx == 0) { // 맨 앞에 붙여서 head 변경 시
				if (head != null) { // 한 개 추가 후 조정
					Node newNode = getNewNode(nums[0]);
					newNode.next = head;
					head = newNode;
				} else {
					head = getNewNode(nums[0]);
				}
				// 남은 수 head 이후에 붙임
				idx = 1;
				st = 1;
			}
			Node cur = head;
			// idx 만큼 이동하기
			for (int i = 1; i < idx; i++) {
				cur = cur.next;

			}
			// 숫자들 추가
			for (int i = st; i < nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				newNode.next = cur.next;
				cur.next = newNode;
				cur = newNode;
			}
			if (cur.next == null) {
				tail = cur;
			}
		}

		void delete(int idx, int cnt) { // idx 부터 cnt 만큼 삭제하기
			Node cur = head;
			if (idx == 0) { // 맨 앞이 삭제 시 head 조정
				for (int i = 0; i < cnt; i++) {
					cur = cur.next;
				}
				head = cur;
				return;
			}
			// idx 만큼 이동
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}
			Node anchor = cur; // 삭제되기 직전 위치 기억
			for (int i = 0; i < cnt; i++) {
				cur = cur.next;
			}
			anchor.next = cur.next;
			if (anchor.next == null) {
				tail = anchor;
			}
		}

		void add(int data) { // 제일 뒤에 data 추가
			Node cur = tail;
			Node newNode = getNewNode(data);
			cur.next = newNode;
			tail = newNode;
		}

		void print() { // 출력
			int cnt = 10;
			Node cur = head;
			while (cnt-- > 0) {
				sb.append(cur.data + " ");
				cur = cur.next;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			LinkedList list = new LinkedList();
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[] initArr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				initArr[i] = Integer.parseInt(st.nextToken());
			}
			list.insert(0, initArr);
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				char cmd = st.nextToken().charAt(0);
				int x, y;
				switch (cmd) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					int[] temp = new int[y];
					for (int j = 0; j < y; j++) {
						temp[j] = Integer.parseInt(st.nextToken());
					}
					list.insert(x, temp);
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					list.delete(x, y);
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			list.print();
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
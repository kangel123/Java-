package lesson1;

import java.util.*;

class Binary {
	public int[] solution(int[] nums) {
		int[] answer = new int[nums.length];

		// 리턴할 내용 따로 저장
		for (int i = 0; i < answer.length; i++) {
			answer[i] = nums[i];
		}

		// 숫자, 이진수 1의 개수로 HashMap 생성
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int count = 0;
			while (nums[i] != 0) {
				if (nums[i] % 2 == 1) {
					count++;
				}
				nums[i] /= 2;
			}
			map.put(num, count);
		}

		// 정렬
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if (map.get(answer[i]) < map.get(answer[j]) || (map.get(answer[i]) == map.get(answer[j]) && answer[i]<answer[j])) {
					int tmp = answer[i];
					answer[i] = answer[j];
					answer[j] = tmp;
				} 
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Binary T = new Binary();
		System.out.println(Arrays.toString(T.solution(new int[] { 5, 6, 7, 8, 9 })));
		System.out.println(Arrays.toString(T.solution(new int[] { 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(T.solution(new int[] { 12, 5, 7, 23, 45, 21, 17 })));
	}
}
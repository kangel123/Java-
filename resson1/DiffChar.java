package resson1;

import java.util.*;

class DiffChar {
	public int solution(String s) {
		
		// HashMap 사용
		int answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		// 문자 개수 세기
		for (int i = 0; i < s.length(); i++) {
			int a = map.getOrDefault(s.charAt(i), 0) + 1;
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		System.out.println(map);
		for (char a : map.keySet()) {
			for (char b : map.keySet()) {
				if (a != b && map.get(a) == map.get(b) && map.get(a) != 0) {
					map.put(b, map.get(b) - 1);
					answer++;
				}
			}
		}
		System.out.println(map);

		return answer;
	}

	public static void main(String[] args) {
		DiffChar T = new DiffChar();
		System.out.println(T.solution("aaabbbcc"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}
}
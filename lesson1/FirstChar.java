package lesson1;

import java.util.HashMap;

class FirstChar {
	public int solution(String s) {


		// HashMap 사용o
		HashMap<Character, Integer> map = new HashMap<>();		
		// 문자 개수 세기
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);	
		}
		// 인덱스 위치 찾기
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))==1){
				return i+1;
			}
		}
		return -1;

		
//		// HashMap 사용x
//		int answer = 0;
//		for (; answer < s.length(); answer++) {
//			boolean bo = true;
//			char a = s.charAt(answer);
//
//			for (int j = 0; j < s.length(); j++) {
//				char b = s.charAt(j);
//				if (answer != j && a == b) {
//					bo = false;
//				}
//			}
//			if (bo) {
//				answer = answer + 1;
//				return answer;
//			}
//		}
//		return -1;
		
	}

	public static void main(String[] args) {
		FirstChar T = new FirstChar();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
package resson1;

import java.util.*;

class SameChar {
	public int[] solution(String s){
		int[] answer = new int[5];		
		char[] characters= {'a','b','c','d','e'};	// 사용할 문자 배열
		int max = 0;	// 최대값
		// HashMap 사용
		HashMap<Character, Integer> map = new HashMap<>();		
		// 문자 개수 세기
		for(int i=0;i<s.length();i++) {
			int a = map.getOrDefault(s.charAt(i), 0)+1;
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);	
		}
		// 최대 빈도수 찾기
		for(int i: map.values()) {
			if(max<i) {
				max=i;
			}
		}
		// 필요한 문자 개수 구하기
		for(int i=0;i<answer.length;i++) {			
			answer[i]=max-map.getOrDefault(characters[i], 0);
		}
		return answer;
	}

	public static void main(String[] args){
		SameChar T = new SameChar();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}

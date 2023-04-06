package lesson2;

import java.util.*;

class Num5 {
	public String solution(String[] votes, int k) {
		String answer = " ";
		HashMap<String, Integer> map1 = new HashMap<>(); // 추천받은 사람과 빈도수
		HashMap<String, Integer> map2 = new HashMap<>(); // 추천한 사람과 빈도수
		ArrayList<String> list = new ArrayList<>(); // 추천횟수 미만의 학생들
		String[][] a = new String[votes.length][2]; // 투표정보

		// 투표 받은 빈도수
		for (int i = 0; i < votes.length; i++) {
			a[i] = votes[i].split(" ");
			map1.put(a[i][1], map1.getOrDefault(a[i][1], 0) + 1);
		}


		// 투표수가 k번 미만인 학생들만 탈락
		for (String key : map1.keySet()) {
			if (map1.get(key) < k) {
				list.add(key);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			map1.remove(list.get(i));
		}

		// 투표한 학생 수
		for (int i = 0; i < a.length; i++) {
			if (map1.getOrDefault(a[i][1], 0) > 0) {
				map2.put(a[i][0], map2.getOrDefault(a[i][0], 0) + 1);
			}
		}
				
		// 이름 순으로 정렬
		Object[] mapkey = map2.keySet().toArray();
		Arrays.sort(mapkey);
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<mapkey.length;i++) {
			if(max<map2.get(mapkey[i])){
				max=map2.get(mapkey[i]);
				answer=(String)mapkey[i];
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Num5 T = new Num5();
		System.out.println(T.solution(
				new String[] { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "john tom", "park luis", "john luis", "luis tom", "park tom",
				"luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis" }, 2));
		System.out.println(T.solution(new String[] { "cody tom", "john tom", "cody luis", "daniel luis", "john luis",
				"luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "bob tom", "bob park", "park bob", "luis park", "daniel luis",
				"luis bob", "park luis", "tom bob", "tom luis", "john park", "park john" }, 3));
	}
}
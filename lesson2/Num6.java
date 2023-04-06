package lesson2;

import java.util.*;

class Num6 {
	public int getTime(String[] t) {
		int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
		return time;
	}

	public String[] solution(String[] reports, String times) {

		HashMap<String, String> map = new HashMap<>(); //
		ArrayList<String> list = new ArrayList<>(); //
		String[][] a = new String[reports.length][2]; // 정보

		String[] time = times.split(" ");
		int start = getTime(time[0].split(":"));
		int end = getTime(time[1].split(":"));

		// 정보 반대로 저장
		for (int i = 0; i < reports.length; i++) {
			a[i] = reports[i].split(" ");

			map.put(a[i][1], a[i][0]);
		}

		// 시간 순으로 정렬
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);
		
		// 정답구하기
		for (Object v : mapkey) {
			int itime = getTime(((String) v).split(":"));
			if (itime >= start && itime <= end) {
				list.add(map.get(v));
			}
		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		Num6 T = new Num6();
		System.out.println(Arrays.toString(
				T.solution(new String[] { "john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" },
						"08:33 09:45")));
		System.out
				.println(
						Arrays.toString(
								T.solution(
										new String[] { "ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57",
												"bill 17:35", "tom 07:23", "john 15:23", "park 09:59" },
										"15:01 19:59")));
		System.out.println(Arrays.toString(
				T.solution(new String[] { "cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50" },
						"14:20 15:20")));
	}
}
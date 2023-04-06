package lesson2;

import java.util.*;

class Num3 {
	public int solution(int[][] fruit) {
		int answer = 0;
		boolean[] person = new boolean[fruit.length]; // 교환 여부
		int[] min = new int[fruit.length]; // 각각 갖고있는 가장 적은 과일 인덱스 번호

		// 모든 학생을 교환가능으로 만들고 개개인의 가장 적은 과일을 배열로 저장해 놓는다(개수x,과일번호o)
		for (int i = 0; i < fruit.length; i++) {
			person[i] = true;

			int min1 = Integer.MAX_VALUE;
			for (int k = 0; k < fruit[i].length; k++) {
				if (min1 > fruit[i][k]) {
					min1 = fruit[i][k];
					min[i] = k;
				}
			}
		}

		// 교환하기
		for (int i = 0; i < fruit.length; i++) {	// 자기 자신
			for (int j = 0; j < fruit.length; j++) {	// 교환 상대

				if (min[i] != min[j] && person[i] && person[j]) { // 만약 아직 교환을 1번도 안 했고 적은 과일이 다르면
					// 일단 먼저 교환한다
					fruit[i][min[i]]++;
					fruit[j][min[i]]--;
					fruit[i][min[j]]--;
					fruit[j][min[j]]++;

					// 변경 후의 최소값 구하기(min1, min2변한 최소값)
					int min1 = Integer.MAX_VALUE;
					for (int k = 0; k < fruit[i].length; k++) {
						if (min1 > fruit[i][k]) {
							min1 = fruit[i][k];
						}
					}
					int min2 = Integer.MAX_VALUE;
					for (int k = 0; k < fruit[j].length; k++) {
						if (min2 > fruit[j][k]) {
							min2 = fruit[j][k];
						}
					}

					// 변한 최소값의 이득 유무에 따라
					if (min1 > fruit[i][min[i]] - 1 && min2 > fruit[j][min[j]] - 1) { // 변한 최소값이 기존보다 이득이면
						person[i] = false;
						person[j] = false;
						break; // 교환 종료
					} else { // 이득이 아니면
						fruit[i][min[i]]--;
						fruit[j][min[i]]++;
						fruit[i][min[j]]++;
						fruit[j][min[j]]--; // 재반환
					}
				}
			}
		}

		// 각 학생의 가장 적은 과일의 개수의 합
		for (int i = 0; i < fruit.length; i++) {
			int min1 = Integer.MAX_VALUE;
			for (int k = 0; k < fruit[i].length; k++) {
				if (min1 > fruit[i][k]) {
					min1 = fruit[i][k];
				}
			}
			answer += min1;
		}

		return answer;
	}

	public static void main(String[] args) {
		Num3 T = new Num3();
		System.out.println(T.solution(
				new int[][] { { 10, 20, 30 }, { 12, 15, 20 }, { 20, 12, 15 }, { 15, 20, 10 }, { 10, 15, 10 } }));
		System.out.println(T.solution(new int[][] { { 10, 9, 11 }, { 15, 20, 25 } }));
		System.out.println(T.solution(
				new int[][] { { 0, 3, 27 }, { 20, 5, 5 }, { 19, 5, 6 }, { 10, 10, 10 }, { 15, 10, 5 }, { 3, 7, 20 } }));
		System.out.println(T.solution(new int[][] { { 3, 7, 20 }, { 10, 15, 5 }, { 19, 5, 6 }, { 10, 10, 10 },
				{ 15, 10, 5 }, { 3, 7, 20 }, { 12, 12, 6 }, { 10, 20, 0 }, { 5, 10, 15 } }));
	}
}

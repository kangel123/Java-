package resson1;

import java.util.Arrays;

public class Solution {

	public char[] solution(int n, int[][] ladder) { // get 2 parameter
		char[] answer = new char[n];
		// 결과 A,B,C로 생성
		for (int i = 0; i < n; i++) {
			answer[i] = (char) (65 + i);
		}

//		for(int[] line : ladder) {
//			for(int x : line) {line=1,3
//				char tmp = answer[x];
//				answer[x] = answer[x - 1];
//				answer[x - 1] = tmp;
//			}
//		}
		
		// 사다리 타기
		for (int i = 0; i < ladder.length; i++) { // 사다리 행
			for (int j = 0; j < ladder[i].length; j++) { // 사다리 열
				int x = ladder[i][j]; 
				char tmp = answer[x];
				answer[x] = answer[x - 1];
				answer[x - 1] = tmp;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][] { { 1, 3 }, { 2, 4 }, { 1, 4 } })));
		System.out.println(Arrays.toString(T.solution(7, new int[][] { { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
		System.out.println(
				Arrays.toString(T.solution(8, new int[][] { { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
		System.out.println(Arrays.toString(T.solution(12,
				new int[][] { { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));
	}
}

package lesson2;

import java.util.*;

class Num1 {
	public int[] solution(int c, int r, int k) {
		
		int[] answer = { 1, 1 };
		int[][] t = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int a = 0;
		boolean[][] seat = new boolean[r][c];

		if(k>r*c)return new int[] {0,0};	// 범위 초과시 계산x
		// 빈 좌석 만들기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				seat[i][j] = false;
			}
		}

		int i = 0, j = 0, count=1;
		while (k > count) {
			int ni = i+t[a][0];
			int nj = j+t[a][1];
			if (ni < 0 || nj < 0 || ni >= r || nj >= c || seat[ni][nj]) {
				a = (a + 1) % 4;				
			} else {
				seat[i][j] = true;
				count++;
				i=ni;
				j=nj;
			}
			
		}
		answer[0] += i;
		answer[1] += j; 
		return answer;
	}

	public static void main(String[] args) {
		Num1 T = new Num1();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
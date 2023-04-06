package lesson1;

import java.util.*;

class Clean {
	public int[] solution(int[][] board, int k) {
		int[] answer = new int[2];

		int[][] b = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };	// ����
		int t = 0;	// ���� ����
		int i = 0;	// ��
		int j = 0;	// ��
		
		for (int n = 0; n < k; n++) {
			i += b[t][0];
			j += b[t][1];
			
			if (i >= board.length || j >= board.length || i < 0 || j < 0 || board[i][j] == 1) {	// ���� ����ų� ��ֹ��� ������
				i -= b[t][0];
				j -= b[t][1];
				t += 1;
				if (t == 4) t = 0;
			} else{	// ������̸�
				answer[0] = i;
				answer[1] = j;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Clean T = new Clean();
		int[][] arr1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = { { 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}
}
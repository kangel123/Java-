package lesson2;

import java.util.*;

class Num3 {
	public int solution(int[][] fruit) {
		int answer = 0;
		boolean[] person = new boolean[fruit.length]; // ��ȯ ����
		int[] min = new int[fruit.length]; // ���� �����ִ� ���� ���� ���� �ε��� ��ȣ

		// ��� �л��� ��ȯ�������� ����� �������� ���� ���� ������ �迭�� ������ ���´�(����x,���Ϲ�ȣo)
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

		// ��ȯ�ϱ�
		for (int i = 0; i < fruit.length; i++) {	// �ڱ� �ڽ�
			for (int j = 0; j < fruit.length; j++) {	// ��ȯ ���

				if (min[i] != min[j] && person[i] && person[j]) { // ���� ���� ��ȯ�� 1���� �� �߰� ���� ������ �ٸ���
					// �ϴ� ���� ��ȯ�Ѵ�
					fruit[i][min[i]]++;
					fruit[j][min[i]]--;
					fruit[i][min[j]]--;
					fruit[j][min[j]]++;

					// ���� ���� �ּҰ� ���ϱ�(min1, min2���� �ּҰ�)
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

					// ���� �ּҰ��� �̵� ������ ����
					if (min1 > fruit[i][min[i]] - 1 && min2 > fruit[j][min[j]] - 1) { // ���� �ּҰ��� �������� �̵��̸�
						person[i] = false;
						person[j] = false;
						break; // ��ȯ ����
					} else { // �̵��� �ƴϸ�
						fruit[i][min[i]]--;
						fruit[j][min[i]]++;
						fruit[i][min[j]]++;
						fruit[j][min[j]]--; // ���ȯ
					}
				}
			}
		}

		// �� �л��� ���� ���� ������ ������ ��
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

package lesson1;

import java.util.*;

public class Titanic {
	public int solution(int[] nums, int m) {

		int answer = 0;	// ��Ʈ ��

		// ����
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}

		// ������ ����� ���ſ� ������� �� ��Ʈ �¿��
		int left=0, right=nums.length-1;
		while(left <= right){
			if(nums[left] + nums[right] <= m){	// ��Ʈ�� 2���� Ż �� ������ 
				answer++;
				left++;
				right--;
			}
			else{	// 1��ۿ� �ȵǸ�
				answer++;
				left++;	// ���ſ� ����� Ÿ�� ������
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Titanic T = new Titanic();
		System.out.println(T.solution(new int[] { 90, 50, 70, 100, 60 }, 140));
		System.out.println(T.solution(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 100));
		System.out.println(T.solution(
				new int[] { 68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81 }, 120));
	}
}

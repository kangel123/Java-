package lesson2;

import java.util.*;

class Num2 {
	public int solution(int[] nums) {
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			int n = nums[i];
			int j;
			for (j = i+1; j < nums.length; j++) {
				if (n < nums[j]) {
					count++;
					n = nums[j];
				} else {
					break;
				}
			}
			for (; j < nums.length; j++) {
				if (n > nums[j]) {
					count++;
					n = nums[j];
				}  else {
					break;
				}
			}

			if(max<count) {
				max=count;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Num2 T = new Num2();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}
}
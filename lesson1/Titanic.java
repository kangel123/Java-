package lesson1;

import java.util.*;

public class Titanic {
	public int solution(int[] nums, int m) {

		int answer = 0;	// 보트 수

		// 정렬
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}

		// 가벼운 사람과 무거운 사람끼리 한 보트 태우기
		int left=0, right=nums.length-1;
		while(left <= right){
			if(nums[left] + nums[right] <= m){	// 보트에 2명이 탈 수 있으면 
				answer++;
				left++;
				right--;
			}
			else{	// 1명밖에 안되면
				answer++;
				left++;	// 무거운 사람만 타기 때문에
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

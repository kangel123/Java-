package lesson1;

public class MaxLength {
	public int solution(int[] nums){
		int answer = 0;
		int max = 1;
		// 정렬하기
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		
		
		// 연속된 수열 찾기
		for(int i=0;i<nums.length;i++) {
			int count = 1;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+1==nums[j]) {
					count++;
					i=j;
				} else if(nums[i]==nums[j]) {					
				} else {
					break;
				}
			}
			
			if(max<count) {
				max=count;
			}
		}
		
		return max;
	}

	public static void main(String[] args){
		MaxLength T = new MaxLength();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
}
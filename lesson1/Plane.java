package lesson1;

import java.util.*;

public class Plane {
	public int solution(int n, int[][] flights, int s, int e, int k) {
		
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++){
			graph.add(new ArrayList<int[]>());
		}
		int[] costs = new int[n];
		Arrays.fill(costs, 1000000000);
		for(int[] x : flights){
			graph.get(x[0]).add(new int[]{x[1], x[2]});
		}
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[]{s, 0});
		costs[s] = 0;
		int L = 0;
		while(!Q.isEmpty()){
			int len = Q.size();
			for(int i = 0; i < len; i++){
				int[] p = Q.poll();
				int now = p[0];
				int nowcost = p[1];
				for(int[] x : graph.get(now)){
					int next = x[0];
					int cost = x[1];
					if(nowcost + cost < costs[next]){
						costs[next] = nowcost + cost;
						Q.offer(new int[]{next, costs[next]});
					}
				}
			}
			L++;
			if(L > k) break; 
		}
		if(costs[e] == 1000000000) return -1;
		else return costs[e];
		
		
//		// k : 최소 가능한 환승
//		// s : 현재 위치
//		// e : 목적지
//		
//		int answer = 0;
//		int min = Integer.MAX_VALUE;
//		
//		for (int j = 0; j < flights.length; j++) {
//			for (int i = 0; i < flights.length; i++) {				
//				if (flights[i][0] == s) {	// 해당 출발 지점이면
//					// 합계
//					answer += flights[i][2];
//					if (answer > 10000)
//						return -1;
//					
//					// 도착하면 종료
//					if (flights[i][1] == e) {
//						break;
//					}
//					
//					// 아닌경우
//					s=i;
//					k -= 1;
//					if (k < 0) break;
//				}
//
//				if (min > answer && flights[i][1] == e) {
//					min = answer;
//				}
//			}
//		}
//		return min;
	}

	public static void main(String[] args) {
		Plane T = new Plane();
		System.out.println(T.solution(5, new int[][] { { 0, 1, 10 }, { 1, 2, 20 }, { 0, 2, 70 }, { 0, 3, 100 },
				{ 1, 3, 80 }, { 2, 3, 10 }, { 2, 4, 30 }, { 3, 4, 10 } }, 0, 3, 1));
		System.out
				.println(T.solution(4, new int[][] { { 0, 1, 10 }, { 0, 2, 10 }, { 1, 3, 5 }, { 2, 3, 3 } }, 0, 3, 0));
		System.out.println(T.solution(8, new int[][] { { 0, 3, 10 }, { 1, 5, 10 }, { 1, 7, 100 }, { 0, 1, 10 },
				{ 0, 2, 10 }, { 5, 7, 30 }, { 3, 7, 10 }, { 1, 3, 5 }, { 2, 3, 3 } }, 1, 7, 2));
		System.out.println(T.solution(10,
				new int[][] { { 1, 8, 50 }, { 0, 8, 30 }, { 1, 0, 10 }, { 2, 8, 10 }, { 0, 3, 10 }, { 1, 5, 10 },
						{ 1, 7, 100 }, { 0, 1, 10 }, { 0, 2, 10 }, { 5, 7, 30 }, { 3, 7, 10 }, { 1, 3, 5 },
						{ 2, 3, 3 } },
				1, 8, 2));
	}
}

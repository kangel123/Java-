package lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class coffee {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			System.out.print("주문한 잔 : ");
			int num = scan.nextInt(); // 주문한 잔
			int free = num / 10; // 무료커피
			int amount = 2000 * (num - free); // 지불금액
			int profit = (int) (amount * 0.66 - 10000 / 60.0 * num * 3); // 순수익 = 커피의 수익률 - 알바 시급
			
			if (amount < 0 || profit < 0) {
				System.out.println("계산할 수 있는 영역을 벗어났습니다");
			} else {
				System.out.println("지불금액:" + amount + "원");
				System.out.println("순수익:" + profit + "원");
				System.out.println("무료커피:" + free + "잔");
				System.out.println("대기시간:" + num * 3 + "분");
			}
		} catch (InputMismatchException e) {
			System.out.println("입력값이 허용범위를 초과하였습니다");
		} catch(Exception e) {
			System.out.println("알 수 없는 에러");
		}
		
	}
}

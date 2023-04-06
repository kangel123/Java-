package lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class coffee {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			System.out.print("�ֹ��� �� : ");
			int num = scan.nextInt(); // �ֹ��� ��
			int free = num / 10; // ����Ŀ��
			int amount = 2000 * (num - free); // ���ұݾ�
			int profit = (int) (amount * 0.66 - 10000 / 60.0 * num * 3); // ������ = Ŀ���� ���ͷ� - �˹� �ñ�
			
			if (amount < 0 || profit < 0) {
				System.out.println("����� �� �ִ� ������ ������ϴ�");
			} else {
				System.out.println("���ұݾ�:" + amount + "��");
				System.out.println("������:" + profit + "��");
				System.out.println("����Ŀ��:" + free + "��");
				System.out.println("���ð�:" + num * 3 + "��");
			}
		} catch (InputMismatchException e) {
			System.out.println("�Է°��� �������� �ʰ��Ͽ����ϴ�");
		} catch(Exception e) {
			System.out.println("�� �� ���� ����");
		}
		
	}
}

package ua.lviv.lgs.max;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {
	static void menu() {
		System.out.println("�������� 1, ��� ������ �����");
		System.out.println("�������� 2, ��� �������� �����");
		System.out.println("�������� 3, ��� ������� �����");
		System.out.println("�������� 4, ��� ��������� ����� �� ������");
		System.out.println("�������� 5, ��� ��������� ����� �� ��������");
		System.out.println("�������� 6, ��� ��������� ����� �� �������");
		System.out.println("�������� 7, ��� ��������� ����� �� �����");
		System.out.println("�������� 8, ��� ������� �-�� ������� ��������");
		System.out.println("�������� 9, ��� ����� � ��������");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Commodity commodity = new Commodity("Box", 20, 30, 24);

		while (true) {
			menu();
			switch (scanner.next()) {
			case "1": {
				commodity.addCommodity();
			}

				break;

			case "2": {
				commodity.removeCommodity();
			}
				break;

			case "3": {
				commodity.commoditySubstitution();
			}
				break;

			case "4": {
				commodity.sortByName();
			}
				break;

			case "5": {
				commodity.sortByLength();
			}
				break;

			case "6": {
				commodity.sortByWidth();
			}
				break;

			case "7": {
				commodity.sortByWeight();
			}
				break;

			case "8": {
				commodity.showElement();
			}
				break;

			case "9": {
				commodity.exit();
			}
				break;
			}
		}

	}

}

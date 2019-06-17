package ua.lviv.lgs.max;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {
	static void menu() {
		System.out.println("Натисніть 1, щоб додати товар");
		System.out.println("Натисніть 2, щоб видалити товар");
		System.out.println("Натисніть 3, щоб замінити товар");
		System.out.println("Натисніть 4, щоб сортувати товар за назвою");
		System.out.println("Натисніть 5, щоб сортувати товар за довжиною");
		System.out.println("Натисніть 6, щоб сортувати товар за шириною");
		System.out.println("Натисніть 7, щоб сортувати товар за вагою");
		System.out.println("Натисніть 8, щоб вивести і-ий елемент колекції");
		System.out.println("Натисніть 9, щоб вийти з програми");
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

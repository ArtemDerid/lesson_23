package ua.lviv.lgs;

import java.util.Optional;
import java.util.Scanner;

public class Main {

	static void menu() {
		System.out.println("������ 1, ��� ������ �������");
		System.out.println("������ 2, ��� �������� ��������� �������");
		System.out.println("������ 3, ��� ������� ��  �������");
		System.out.println("������ 4, ��� �������� ��������� �������");
		System.out.println("������ 5, ��� ������� ��������� �������");
		System.out.println("������ 6, ��� ������ �������� � �������");
		System.out.println("������ 7, ��� �������� �������� � �������");
		System.out.println("������ 8, ��� ������� ������ ���������");
		System.out.println("������ 9, ��� ������� ���������� ���������");
	}

	public static void main(String[] args) {

		Parlament parlament = Parlament.getInstance();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();
			switch (scanner.next()) {
			case "1": {
				parlament.addFaction();
			}
				break;

			case "2": {
				parlament.removeFaction();
			}
				break;

			case "3": {
				parlament.showAllFactions();
			}
				break;

			case "4": {
				System.out.println("������ ����� �������");
				scanner = new Scanner(System.in);
				String name = scanner.next();
				
				Optional<Faction> faction = Parlament.getInstance().listOfFactions.stream().filter(f->f.getName().equals(name)).findFirst();
				
				if (faction.isPresent()) {
					faction.get().cleanFaction();
					System.out.println("�� �������� ������� "+ faction.get());
				}else {
					System.out.println("���� ������� �� ����");
				}

//				for (Faction faction : parlament.listOfFactions) {
//					if (faction.getName().equalsIgnoreCase(name)) {
//						faction.cleanFaction();
//						System.out.println("�� �������� ������� "+ faction);
//					}
//				}
			}
				break;

			case "5": {
				parlament.showFaction();
			}
				break;

			case "6": {
				parlament.addDeputyToFaction();
			}
				break;

			case "7": {
				parlament.removeDeputy();
			}
				break;

			case "8": {
				parlament.showAllGrafters();
			}
				break;

			case "9": {
				parlament.showBiggestGrafterInFaction();
			}
			}
		}
	}

}

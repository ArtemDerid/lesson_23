package ua.lviv.lgs;

import java.util.Optional;
import java.util.Scanner;

public class Main {

	static void menu() {
		System.out.println("Введіть 1, щоб додати фракцію");
		System.out.println("Введіть 2, щоб видалити конкретну фракцію");
		System.out.println("Введіть 3, щоб вивести усі  фракції");
		System.out.println("Введіть 4, щоб очистити конкретну фракцію");
		System.out.println("Введіть 5, щоб вивести конкретну фракцію");
		System.out.println("Введіть 6, щоб додати депутата в фракцію");
		System.out.println("Введіть 7, щоб видалити депутата з фракції");
		System.out.println("Введіть 8, щоб вивести список хабарників");
		System.out.println("Введіть 9, щоб вивести найбільшого хабарника");
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
				System.out.println("Введіть назву фракції");
				scanner = new Scanner(System.in);
				String name = scanner.next();
				
				Optional<Faction> faction = Parlament.getInstance().listOfFactions.stream().filter(f->f.getName().equals(name)).findFirst();
				
				if (faction.isPresent()) {
					faction.get().cleanFaction();
					System.out.println("Ви очистили фракцію "+ faction.get());
				}else {
					System.out.println("Такої фракції не існує");
				}

//				for (Faction faction : parlament.listOfFactions) {
//					if (faction.getName().equalsIgnoreCase(name)) {
//						faction.cleanFaction();
//						System.out.println("Ви очистили фракцію "+ faction);
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

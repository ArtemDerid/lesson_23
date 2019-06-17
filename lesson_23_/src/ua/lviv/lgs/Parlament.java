package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parlament {

	private static final Parlament instance = new Parlament();

	private Parlament() {
	}

	public static Parlament getInstance() {
		return instance;
	}

	List<Faction> listOfFactions = new ArrayList<>();

	public void addFaction() {
		Supplier<Faction> createFaction = () -> {
			System.out.println("������ ����� �������");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			listOfFactions.add(new Faction(name));
			System.out.println("�� ������ ���� �������: " + name);
			return new Faction(name);
		};
		createFaction.get();
	}

	public void removeFaction() {
		System.out.println("������ ����� �������");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		Optional<Faction> removedFaction = listOfFactions.stream()
				.filter(f -> f.getName().equalsIgnoreCase(nameOfFaction)).findFirst().map(f -> {
					listOfFactions.remove(f);
					return f;
				});

		if (removedFaction.isPresent()) {
			System.out.println("�� �������� ������� " + removedFaction.get());
		} else {
			System.out.println("���� ������� �� ����");
		}

	}

	public void showAllFactions() {
		listOfFactions.stream().forEach(System.out::println);
	}

	public void showFaction() {
		System.out.println("������ ����� �������");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		Optional<Faction> showFaction = listOfFactions.stream().filter(f -> f.getName().equalsIgnoreCase(nameOfFaction))
				.findFirst();

		if (showFaction.isPresent()) {
			System.out.println(showFaction.get());
		} else {
			System.out.println("���� ������� �� ����");
		}
	}

	public void addDeputyToFaction() {
		System.out.println("������ ����� �������");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		Optional<Faction> faction = listOfFactions.stream().filter(f -> f.getName().equalsIgnoreCase(nameOfFaction))
				.findFirst();

		if (faction.isPresent()) {
			Faction myFaction = faction.get();
			myFaction.addDeputy();
		} else {
			System.out.println("���� ������� �� ����");
		}

	}

	// ����� �������� � ��������� �������
	public void removeDeputy() {
		System.out.println("������ ����� �������");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();
		
		Optional<Faction> faction = listOfFactions.stream().filter(f -> f.getName().equalsIgnoreCase(nameOfFaction))
				.findFirst();
		
		if (faction.isPresent()) {
			Faction myFaction = faction.get();
			myFaction.removeDeputy();
		} else {
			System.out.println("���� ������� �� ����");
		}
	}

	public void showAllGrafters() {
		listOfFactions.stream().forEach(Faction::showGrafter);
	}

	public void showBiggestGrafterInFaction() {
		listOfFactions.stream().forEach(Faction::showBiggestGrafter);
	}

	public void showAllDeputiesInFaction() {
		listOfFactions.stream().forEach(Faction::showAllDeputies);
	}


}

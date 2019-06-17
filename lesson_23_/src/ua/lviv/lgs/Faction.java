package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Faction {

	private String name;

	public Faction(String name) {
		super();
		this.name = name;
	}

	List<Deputy> listOfDeputies = new ArrayList<>();

	public void addDeputy() {
		Supplier<Deputy> createDeputy = () -> {
			System.out.println("Введіть депутата");

			System.out.println("Введіть вагу");
			Scanner sc = new Scanner(System.in);
			Double weight = sc.nextDouble();

			System.out.println("Введіть ріст");
			sc = new Scanner(System.in);
			int height = sc.nextInt();

			System.out.println("Введіть ім'я");
			sc = new Scanner(System.in);
			String name = sc.next();

			System.out.println("Введіть прізвище");
			sc = new Scanner(System.in);
			String secondName = sc.next();

			System.out.println("Введіть вік");
			sc = new Scanner(System.in);
			int age = sc.nextInt();

			System.out.println("Депутат - хабарник? якщо так - натисніть 1, якщо ні - натисніть 2");
			sc = new Scanner(System.in);
			int grafter = sc.nextInt();
			isGrafter(grafter);

			Deputy deputy = new Deputy(weight, height, secondName, name, age, isGrafter(grafter));

			listOfDeputies.add(deputy);

			if (isGrafter(grafter) == true) {
				deputy.giveGraft();
			}

			System.out.println("Ви додали депутата " + deputy);
			return deputy;
		};
		createDeputy.get();
	}

	public void removeDeputy() {
		System.out.println("Прізвище депутата, якого хочете видалити");

		Scanner sc = new Scanner(System.in);
		String secondName = sc.next();

		System.out.println("Ім'я депутата, якого хочете видалити");

		sc = new Scanner(System.in);
		String name = sc.next();

		Optional<Deputy> removedDeputy = listOfDeputies.stream()
				.filter(d -> d.getName().equalsIgnoreCase(name) && d.getSecondName().equalsIgnoreCase(secondName))
				.findAny().map(d -> {
					listOfDeputies.remove(d);
					return d;
				});
		if (removedDeputy.isPresent()) {
			System.out.println("Видалено депутата " + removedDeputy.get());
		} else {
			System.out.println("Такого депутата не знайдено");
		}

	}

	public void showGrafter() {
		List<Deputy> listOfGrafters = listOfDeputies.stream().filter(d -> d.isGrafter() == true)
				.peek(deputy -> System.out
						.println(deputy.getSecondName() + " " + deputy.getName() + " отримав " + deputy.getGraft()))
				.collect(Collectors.toList());
		System.out.println(listOfGrafters);
	}

	public void showBiggestGrafter() {
		Deputy biggestGrafter = listOfDeputies.stream().sorted(new DeputiesGraftComparator())
				.collect(Collectors.toList()).get(0);
		if(biggestGrafter.getGraft() != 0) {
			System.out.println("Найбільший хабарник - " + biggestGrafter);
		}else {
			System.out.println("У цій фракції хабарників немає");
		}
	}

	public void showAllDeputies() {
		listOfDeputies.stream().forEach(System.out::println);
	}

	public void cleanFaction() {
		listOfDeputies.clear();
	}

	public boolean isGrafter(int grafter) {
		if (grafter == 1) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Deputy> getListOfDeputies() {
		return listOfDeputies;
	}

	public void setListOfDeputies(List<Deputy> listOfDeputies) {
		this.listOfDeputies = listOfDeputies;
	}

	@Override
	public String toString() {
		return "Faction [name=" + name + ", listOfDeputies=" + listOfDeputies + "]";
	}

}

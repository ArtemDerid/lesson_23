package ua.lviv.lgs;

import java.util.Scanner;

public class Deputy extends Human{
	
	private String secondName;
	private String name;
	private int age;
	private boolean grafter;
	private double graft;
	
	public Deputy(double weight, int height, String secondName, String name, int age, boolean grafter) {
		super(weight, height);
		this.secondName = secondName;
		this.name = name;
		this.age = age;
		this.grafter = grafter;
	}
	
	void giveGraft() {
		if(grafter == false) {
			System.out.println("Цей депутат не бере хабарів");
		}else {
			System.out.println("Введіть суму хабаря");
			Scanner sc = new Scanner(System.in);
			Double input = sc.nextDouble();
			if(input>5000) {
				System.out.println("Депутат сяде за ґрати");
			}else {
				setGraft(input);
			}
		}
	}
	
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGrafter() {
		return grafter;
	}

	public void setGrafter(boolean grafter) {
		this.grafter = grafter;
	}

	public double getGraft() {
		return graft;
	}

	public void setGraft(double graft) {
		this.graft = graft;
	}

	@Override
	public String toString() {
		return "Deputy [secondName=" + secondName + ", name=" + name + ", age=" + age + ", grafter=" + grafter
				+ ", weight=" + getWeight() + ", height=" + getHeight() + "]";
	}

	

	

}

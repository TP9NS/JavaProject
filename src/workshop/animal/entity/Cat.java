package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String name;
	
	public Cat(String name) {
		super(4);
		setName(name);
	}
	
	public Cat() {
		this("");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 장화를 신고 놀아용!");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 생선을 먹어용!");
	}
}

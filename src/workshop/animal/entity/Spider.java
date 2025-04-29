package workshop.animal.entity;

public class Spider extends Animal {
	public Spider() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("Spider는 작은 벌레를 먹어용!");
		
	}
}

package workshop.person.control;

import workshop.person.entity.PersonEntity;

public class PersonManager {
	public static void main(String[] args) {
		/*
		 * persons 는 PersonEntity[] 타입
		 * persons[0] 는 PersonEntity 타입
		 */
		//PersonEntity 타입인 배열을 선언 및 생성
		PersonEntity[] persons = new PersonEntity[10];
		//Person객체생성
		//PersonEntity person = new PersonEntity();
		
		PersonManager mgr = new PersonManager();		
		mgr.fillPersons(persons);
		
		mgr.showPersons(persons);
		
		System.out.println(mgr.findByGender(persons, '여'));
		
		mgr.showPerson(persons, "김하늘");
	}

	public void showPersons(PersonEntity[] persons) {
		//Enhanced for Loop
		for (PersonEntity person : persons) {
			System.out.println(person.getName() + "\t" + person.getGender() + "\t" + person.getPhone());
		}
	}

	//non-static method
	public void fillPersons(PersonEntity[] persons) {
		//PersonEntity배열 초기화 
		persons[0] = new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
		persons[2] = new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542");
		persons[3] = new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223");
		persons[4] = new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333");
		persons[5] = new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934");
		persons[6] = new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932");
		persons[7] = new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939");
		persons[8] = new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202");
		persons[9] = new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832");
	}
	
	
	public int findByGender(PersonEntity[] persons, char gender) {
		int genderCnt = 0;
		for (PersonEntity person : persons) {
			//char 타입은 primitive 타입으로 값을 비교할때 == 연산자를 사용해도 됨
			if(person.getGender() == gender) {
				genderCnt++;
			}
		}
		return genderCnt;
	}
	
	public void showPerson(PersonEntity[] persons, String name) {
		for (PersonEntity person : persons) {
			//String은 reference 타입이므로 값을 비교할때 equals() 메서드를 사용해야 함
			if(person.getName().equals(name)) {
				System.out.println("[이름] " + person.getName());
				System.out.println("[성별] " + person.getGender());
				System.out.println("[전화번호] " + person.getPhone());
				System.out.println("[주소] " + person.getAddress());
				break;
			}
		}
	}
	
}
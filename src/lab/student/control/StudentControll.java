package lab.student.control;

import lab.student.entitiy.Student;

public class StudentControll {
	public static void main(String[] args) {
		Student student1 = new Student("1","��μ�","��ǻ�� ����",3);
		student1.printStudent();
		student1.setGrade(5);
	}
	
}

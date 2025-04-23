
package lab.student.entitiy;
public class Student {
	
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student(String studentId,String name,String major,int grade) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade= grade;
	}
	
	//getter
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}
	//setter
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGrade(int grade) {
		 if (grade < 5 && grade >0) {
			 this.grade = grade;
		 }else {
			 System.out.println("올바른 값을 입력");
		 }
	}
	public void printStudent() {
		System.out.println(studentId+"//"+name+"//"+major+"//"+grade);
	}

}

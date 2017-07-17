import javax.xml.bind.annotation.XmlAttribute;


public class Student {

	private String name;
	private int age;
	private String gender;
	private int rollNo;
	
	
	
	public Student() {
		super();
		
	}

	public Student(String name, int age, String gender, int rollNo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.rollNo = rollNo;
	}
	
	
	public int getRollNo() {
		return rollNo;
	}

	@XmlAttribute
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}

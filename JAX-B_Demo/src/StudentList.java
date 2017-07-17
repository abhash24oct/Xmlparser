import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="StudentList")
public class StudentList {
	
	
	private List<Student> studentlist;

	public List<Student> getStudentlist() {
		return studentlist;
	}

	@XmlElement(name="Student")
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
	
	

}

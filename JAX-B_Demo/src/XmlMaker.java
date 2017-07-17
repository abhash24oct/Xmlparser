import java.util.*;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class XmlMaker {

	public static void main(String[] args) {
		
		Student st1 = new Student("Abhash", 24, "Male", 1);
		Student st2 = new Student("Tom", 24, "Male", 6);
		Student st3 = new Student("Sid", 24, "Male", 2);
		
		
		StudentList stl = new StudentList();
		java.util.List<Student> studentlist2 = new ArrayList<Student>();
		studentlist2.add(st1);
		studentlist2.add(st2);
		studentlist2.add(st3);
		stl.setStudentlist(studentlist2);
		
		System.out.println(stl.getStudentlist());
		
		try{
			File f = new File("student.xml");
			
			JAXBContext jaxbcontext = JAXBContext.newInstance(StudentList.class);
			
			/*
			 * marshal : convert object to xml
			 * 
			 */
			Marshaller jaxmarshaller= jaxbcontext.createMarshaller();
			
			
			jaxmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxmarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,"com.abahsh.jaxb");
			jaxmarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "techm");
			
			jaxmarshaller.marshal(stl, f);
			jaxmarshaller.marshal(stl, System.out);
			
					
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}

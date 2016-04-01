package com;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public class TreeSetTest {

	public TreeSetTest() {
		//Set<Student> students = new LinkedHashSet<Student>();
		//Set<Student> students = new HashSet<Student>();
		Set<Student> students = new TreeSet<Student>();
		Random ranObj = new Random();
		for(int i=0; i<= 10; i++)
		{
			int rand = ranObj.nextInt(100);
			System.out.println("Adding student with roll no: " + rand );
			students.add(new Student(rand, "Student" + (i+1)));
		}
		
		for(Student student: students)
		{
			System.out.println("Student : " + student.getId() + " : " + student.getName());
		}
	}

	public static void main(String[] args) {
		TreeSetTest tst = new TreeSetTest();
	}

}

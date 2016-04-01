package com;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public MapTest() {
				
	}

	public static void main(String[] args) {
		Map<Student, Faculty> studentFacultyMap = new HashMap<Student, Faculty>();
		Student s1 = new Student(505, "Araja Jyothi Babu");
		//Student s2 = new Student(506, "Jyothi Babu");
		//Student s3 = new Student(507, "Jyothi Babu ARaja");
		
		Faculty f1 = new Faculty(123, "Fac1");
		//Faculty f2 = new Faculty(125, "Fac2");
		
		studentFacultyMap.put(s1, f1);
		
		Student toSearch = new Student(505, "Araja Jyothi Babu");
		
		Faculty fac = studentFacultyMap.get(toSearch);
		
		System.out.println("Comparison: " + s1.equals(toSearch));
		System.out.println("Hash Comparison: " + s1.hashCode());
		System.out.println("Hash Comparison: " + toSearch.hashCode());
		
		System.out.println("Faculty for : " + fac);
		
	}

}

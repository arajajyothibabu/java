package tcs;

import java.util.Scanner;

/**
 * Created by Araja Jyothi Babu on 25-02-2016.
 */
public class Test {
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter No: of seats available in college: ");
        College college = new College(in.nextInt());
        System.out.println("*************Start the academic Activity****************");
        while(true){
            System.out.println("\nMenu: 1.addStudent 2.findStudent 3. updateStudentName 4. updateStudentBranch 0.Exit");
            switch(in.nextInt()){
                case 1:
                    if(college.seatsAvailability()) {
                        System.out.println("Enter Name: ");
                        String name = in.next();
                        System.out.println("Enter Branch: ");
                        String branch = in.next();
                        Student student = new Student(college.getNextId(), name, branch);
                        System.out.println(college.addStudent(student));
                    }else{
                        System.out.println("No seats available..!");
                    }
                    break;
                case 2:
                    System.out.println("Enter Student Id: ");
                    System.out.println(college.findStudent(in.next()));
                    break;
                case 3:
                    System.out.println("Enter Student Id and Name: ");
                    System.out.println(college.updateStudentName(in.next(),in.next()));
                    break;
                case 4:
                    System.out.println("Enter Student Id and Branch: ");
                    System.out.println(college.updateStudentBranch(in.next(),in.next()));
                    break;
                case 0:
                    System.exit(1);
                    default: System.out.println("Invalid Option. Try again..!");
            }
        }
    }
}

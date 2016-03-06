package tcs;
/**
 * Created by Araja Jyothi Babu on 25-02-2016.
 */
public class College {
    private int capacity;
    private Student[] students;
    static int roll = 0;
    static String idPrefix = "12131A05";

    College(int capacity){
        this.capacity = capacity;
        students = new Student[capacity];
    }

    boolean seatsAvailability(){
        return roll < capacity;
    }

    String getNextId(){
        return idPrefix + (roll<9? "0" : "" ) + (roll+1);
    }

    String addStudent(Student student){
        this.students[roll++] = student;
        return "Student with id: " + student.getId() + " added to curriculam";
    }

    String findStudent(String id){
        for(int i=0; i< roll; i++){
            if(this.students[i].getId().equals(id)){
                return this.students[i].getName();
            }
        }
        return "Student with id: " + id + " not found..!";
    }

    String updateStudentName(String id, String name){
        for(Student student: students){
            if(student.getId() == id){
                student.setName(name);
                return "Updated student name: " + student.getName();
            }
        }
        return "Update failure. Student with id: "+ id + " not found";
    }

    String updateStudentBranch(String id, String branch){
        for(Student student: students){
            if(student.getId() == id){
                student.setBranch(branch);
                return "Updated student branch: " + student.getBranch();
            }
        }
        return "Update failure. Student with id: "+ id + " not found";
    }

}

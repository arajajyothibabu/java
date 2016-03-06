package tcs.assignment5.Customised_Exception.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class University {

    public String[] addStudent(Student[] students){
        String[] output = new String[students.length];
        String successMessage = "Student with the following details is added successfully to university :\n";
        String failureMessage = "Student cannot be added to university as age is greater than 35 or less than 23\n";
        for(int i = 0; i < students.length; i++){
            try{
                registerStudent(students[i]);
                output[i] = successMessage + "StudentName :" + students[i].getName() +"\nStudent-Email :" + students[i].getEmailId();
            }catch(AgeException ae){
                output[i] = failureMessage + "StudentName :" + students[i].getName() +"\nStudent-Age :" + students[i].getAge();
            }
        }
        return output;
    }

    public static void registerStudent(Student student) throws AgeException {
        int age = student.getAge();
        if(age > 35 || age < 23)
            throw new AgeException();
    }
}

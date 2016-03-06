import java.util.Set;

/**
 * Created by Araja Jyothi Babu on 26-02-2016.
 */
public class AttendanceRecorder implements  Runnable{

    private Set<Student> studentSheet;
    private int num;


    public AttendanceRecorder(int num, Set<Student> studentSheet) {
        this.num = num;
        this.studentSheet = studentSheet;
    }

    @Override
    public void run() {

        int counter = 0;
            for(Student s : studentSheet)
            {
                //System.out.print(s.getMarks());

                if(s.getMarks() > 100)
                {
                    s.setPresent(true);
                    System.out.println("Attendance Recorder Number ::: "+num+" is recording attendance for student number  "+counter++);
                }

            }


    }
}

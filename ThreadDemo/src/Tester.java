import java.util.HashSet;
import java.util.Set;

/**
 * Created by Araja Jyothi Babu on 26-02-2016.
 */
public class Tester {


    public static void main(String[] args) throws InterruptedException {

        Set<Set<Student>> sheets = new HashSet<Set<Student>>();

        Set<Student> sheet1 = new HashSet<>();
        Set<Student> sheet2 = new HashSet<>();
        Set<Student> sheet3 = new HashSet<>();

        for(int i=0; i<=30000; i++)
        {
            Student st = new Student("Stud"+(i+1),i/100);
            if(i%3==0)
                sheet1.add(st);
            else if(i%3 == 1)
                sheet2.add(st);
            else
                sheet3.add(st);

        }

        System.out.println(sheet1.size());

        AttendanceRecorder attRec1 = new AttendanceRecorder(1,sheet1);
        AttendanceRecorder attRec2 = new AttendanceRecorder(2,sheet2);
        AttendanceRecorder attRec3 = new AttendanceRecorder(3,sheet3);


        Thread th = new Thread(attRec1);
        th.start();
        Thread th2 = new Thread(attRec2);
        th2.start();
        Thread th3 = new Thread(attRec3);
        th3.start();

        th.join();
        th2.join();
        th3.join();
    }

}

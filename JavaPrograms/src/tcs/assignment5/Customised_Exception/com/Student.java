package tcs.assignment5.Customised_Exception.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class Student {
    private String name;
    private int age;
    private String sex;
    private String address;
    private String emailId;
    private String qualification;

    public Student() {
    }

    public Student(String name, int age, String sex, String address, String emailId, String qualification) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.emailId = emailId;
        this.qualification = qualification;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}
